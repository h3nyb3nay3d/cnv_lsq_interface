package com.linedata.lsq.controller.dealRelated;

import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.lsq.model.events.DealRequest;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.service.beanRelated.BeanFinderService;
import com.linedata.lsq.service.beanRelated.DealLevelsFillerService;
import com.linedata.lsq.service.kafkaRelated.KafkaConsumerService;
import com.linedata.lsq.service.kafkaRelated.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/blocking/deal")
public class DealsByTiersIdController {

    @Autowired
    private BeanFinderService beanFinderService;

    @Autowired
    private DealLevelsFillerService dealLevelsFillerService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

//////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "dealsByTiers/request")
    public ResponseEntity<?> requestDealsByTiers(
            @RequestParam(name = "tiersId") String tiersId,
            @RequestParam(name = "isSynchronous", defaultValue = "true") boolean synchronous,
            @RequestParam(name = "level", defaultValue = "0") int level
    ) {
        List<Deal> dealList = beanFinderService.getLiteDealsByThirdPartyTiersId(tiersId);
        if (dealList.isEmpty())
            return new ResponseEntity<>("No Tiers With Such Id Was Found", HttpStatus.NOT_FOUND);
        else {
            if (synchronous)
                switch (level) {
                    case 0:
                        return new ResponseEntity<>(dealList.parallelStream().map(DealWrapper::new).collect(Collectors.toList()), HttpStatus.OK);
                    case 1:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal1LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    case 2:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal2LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    case 3:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal3LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    case 4:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal4LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    case 5:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal5LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    case 6:
                        return new ResponseEntity<>(dealList.parallelStream().map(deal -> dealLevelsFillerService.deal6LevelFiller(deal)).collect(Collectors.toList()), HttpStatus.OK);
                    default:
                        return new ResponseEntity<>("Maximum Level (=6) For Deals Was Exceeded", HttpStatus.BAD_REQUEST);
                }
            else {
                switch (level) {
                    case 0:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 0));
                        return new ResponseEntity<>("Deals (Level 0) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 1:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 1));
                        return new ResponseEntity<>("Deals (Level 1) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 2:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 2));
                        return new ResponseEntity<>("Deals (Level 2) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 3:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 3));
                        return new ResponseEntity<>("Deals (Level 3) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 4:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 4));
                        return new ResponseEntity<>("Deals (Level 4) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 5:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 5));
                        return new ResponseEntity<>("Deals (Level 5) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    case 6:
                        kafkaProducerService.sendDealRequest(new DealRequest(tiersId, false, 6));
                        return new ResponseEntity<>("Deals (Level 6) Of This Tier Were Produced To Kafka To Be Consumed Later", HttpStatus.ACCEPTED);
                    default:
                        return new ResponseEntity<>("Maximum Level (=6) For Deals Was Exceeded", HttpStatus.BAD_REQUEST);
                }
            }
        }
    }

    @GetMapping(value = "dealsByTiers/consume")
    public List<List<DealWrapper>> consumePendingDealsByTiersAsynchronous(@RequestParam(name = "fromBeginning", defaultValue = "false") boolean fromBeginning) {
        if (fromBeginning)
            return kafkaConsumerService.consumeDealListsFromBeginning();
        else
            return kafkaConsumerService.consumeDealListsFromCommittedOffset();
    }
}
