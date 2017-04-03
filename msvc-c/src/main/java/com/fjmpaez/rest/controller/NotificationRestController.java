package com.fjmpaez.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1.0")
public class NotificationRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(NotificationRestController.class);

    @RequestMapping(path = "/request", method = RequestMethod.GET)
    public void notifications() {

        LOGGER.info("received request");
    }

}
