package com.linedata.lsq.controller.dealRelated;

import com.linedata.lsq.model.events.DealEventNotification;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.service.beanRelated.BeanFinderService;
import com.linedata.lsq.service.beanRelated.DealLevelsFillerService;
import com.linedata.lsq.service.kafkaRelated.KafkaReactiveConsumerService;
import com.linedata.lsq.service.kafkaRelated.KafkaReactiveProducerService;
import com.linedata.ekip.std.services.deal.entity.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@RestController
@RequestMapping("api/reactive/deal")
public class DealReactiveController {

    @Autowired
    private BeanFinderService beanFinderService;

    @Autowired
    private DealLevelsFillerService dealLevelsFillerService;

    @Autowired
    private KafkaReactiveProducerService kafkaReactiveProducerService;

    @Autowired
    private KafkaReactiveConsumerService kafkaReactiveConsumerService;

    @PostMapping(value = "send")
    public ResponseEntity<String> sendDealOperationEvent(
            @RequestParam(name = "dealExternalId") String dealExternalId,
            @RequestParam(name = "dealOperationEvent") String event,
            @RequestParam(name = "level", defaultValue = "0") int level) {

        if (Arrays.asList("CREATE", "DELETE", "UPDATE").contains(event.toUpperCase())) {
            Deal deal = beanFinderService.getLiteDealByExternalId(dealExternalId);
            if (deal.getId() == null)
                return new ResponseEntity<>("No Deal With Such External Id Was Found", HttpStatus.NOT_FOUND);
            else {
                switch (level) {
                    case 0: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), new DealWrapper(deal)));
                        return new ResponseEntity<>("Deal Event (Level 0) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 1: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal1LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 1) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 2: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal2LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 2) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 3: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal3LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 3) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 4: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal4LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 4) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 5: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal5LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 5) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    case 6: {
                        kafkaReactiveProducerService.sendObject(new DealEventNotification(event.toUpperCase(), dealLevelsFillerService.deal6LevelFiller(deal)));
                        return new ResponseEntity<>("Deal Event (Level 6) Was Sent Successfully", HttpStatus.ACCEPTED);
                    }
                    default:
                        return new ResponseEntity<>("Maximum Level (=6) For Deals Was Exceeded", HttpStatus.BAD_REQUEST);
                }
            }
        } else
            return new ResponseEntity<>("Deal Event Was Not Recognized", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "notification/consume", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Object> consumeDealsNotifications() {
        return kafkaReactiveConsumerService.consumeDeals();
    }

}
