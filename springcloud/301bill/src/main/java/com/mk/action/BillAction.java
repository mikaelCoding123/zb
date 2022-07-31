package com.mk.action;

import com.mk.service.BillService;
import com.response.ServiceResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("bill")
public class BillAction {

    @Resource
    private BillService billService;
    @RequestMapping("query")
    public ServiceResult getBill(@RequestBody String userid ){
        return billService.queryBill(userid);
    }

}
