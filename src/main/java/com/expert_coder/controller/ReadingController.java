package com.expert_coder.controller;


import com.expert_coder.entity.Reading;
import com.expert_coder.service.AlertService;
import com.expert_coder.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://mocker.ennate.academy/"}, maxAge = 6000)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    private ReadingService service;
    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Reading reading) {
        alertService.checkForAlert(reading);
        service.create(reading);
    }
}
