package com.process.data.controller;

import com.process.data.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("baseData")
public class BaseDataController {
    @Autowired
    private BaseDataService service;

    @RequestMapping(value = "/updateGroup",method = {RequestMethod.GET,RequestMethod.POST})
    public void updateGroup(){
        service.updateGroup();
    }
}
