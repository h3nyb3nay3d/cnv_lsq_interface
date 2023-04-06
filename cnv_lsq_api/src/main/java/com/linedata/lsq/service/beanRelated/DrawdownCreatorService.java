package com.linedata.lsq.service.beanRelated;

import com.linedata.ekip.std.dao.core.exception.EkipApiException;
import com.linedata.ekip.std.services.drawdown.entity.Drawdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawdownCreatorService {
    @Autowired
    private BeanFactoryService beanFactoryService;

    public void createDrawdown(Drawdown drawdown) throws EkipApiException {
        beanFactoryService.drawdownService.create(beanFactoryService.initActionContext(), drawdown);
    }
}
