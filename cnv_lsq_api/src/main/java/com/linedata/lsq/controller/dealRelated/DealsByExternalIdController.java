package com.linedata.lsq.controller.dealRelated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

@RestController
@RequestMapping("api/blocking/deal")
public class DealsByExternalIdController {

    @Autowired
    private BeanFinderService beanFinderService;

    @Autowired
    private DealLevelsFillerService dealLevelsFillerService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

//////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping(value = "dealByExternalId/request")
    public ResponseEntity<?> requestDealByExternalId(
            @RequestParam(name = "dealExternalId") String dealExternalId,
            @RequestParam(name = "isSynchronous", defaultValue = "true") boolean synchronous,
            @RequestParam(name = "level", defaultValue = "0") int level
    ) {

        Deal deal = beanFinderService.getLiteDealByExternalId(dealExternalId);
        if (deal.getId() == null)
            return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "No Deal With Such External Id Was Found"), HttpStatus.NOT_FOUND);
        else {
            if (synchronous) {
                switch (level) {
                    case 0:
                        return new ResponseEntity<>(new DealWrapper(deal), HttpStatus.OK);
                    case 1:
                        return new ResponseEntity<>(dealLevelsFillerService.deal1LevelFiller(deal), HttpStatus.OK);
                    case 2:
                        return new ResponseEntity<>(dealLevelsFillerService.deal2LevelFiller(deal), HttpStatus.OK);
                    case 3:
                        return new ResponseEntity<>(dealLevelsFillerService.deal3LevelFiller(deal), HttpStatus.OK);
                    case 4:
                        return new ResponseEntity<>(dealLevelsFillerService.deal4LevelFiller(deal), HttpStatus.OK);
                    case 5:
                        return new ResponseEntity<>(dealLevelsFillerService.deal5LevelFiller(deal), HttpStatus.OK);
                    case 6:
                        return new ResponseEntity<>(dealLevelsFillerService.deal6LevelFiller(deal), HttpStatus.OK);
                    default:
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Maximum Level (=6) For Deals Was Exceeded"), HttpStatus.BAD_REQUEST);
                }
            } else {
                switch (level) {
                    case 0:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 0));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 0) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 1:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 1));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 1) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 2:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 2));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 2) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 3:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 3));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 3) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 4:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 4));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 4) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 5:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 5));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 5) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    case 6:
                        kafkaProducerService.sendDealRequest(new DealRequest(dealExternalId, true, 6));
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Deal (Level 6) Was Produced To Kafka To Be Consumed Later"), HttpStatus.ACCEPTED);
                    default:
                        return new ResponseEntity<>(new ObjectMapper().createObjectNode().put("response", "Maximum Level (=6) For Deals Was Exceeded"), HttpStatus.BAD_REQUEST);
                }
            }
        }
    }
    @GetMapping(value = "dealsByExternalId/consume")
    public List<DealWrapper> consumePendingDealsByExternalIdAsynchronous(@RequestParam(name = "fromBeginning", defaultValue = "false") boolean fromBeginning) {
        if (fromBeginning)
            return kafkaConsumerService.consumeDealsFromBeginning();
        else
            return kafkaConsumerService.consumeDealsFromCommittedOffset();
    }
}
