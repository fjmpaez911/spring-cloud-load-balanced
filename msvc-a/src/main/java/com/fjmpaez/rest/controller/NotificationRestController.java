package com.fjmpaez.rest.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/v1.0")
public class NotificationRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(NotificationRestController.class);

    @Autowired
    @Qualifier("msvc-b_url")
    private String msvcBUrl;

    @Autowired
    @Qualifier("msvc-c_url")
    private String msvcCUrl;

    @Autowired
    @Qualifier("activeRestTemplate")
    private RestTemplate template;

    private HttpHeaders headers;

    @PostConstruct
    public void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    private HttpEntity<?> getHttpEntity() {
        return new HttpEntity<String>(headers);
    }

    @RequestMapping(path = "/request", method = RequestMethod.GET)
    public void notifications() {

        LOGGER.info("received request");

        // FIXME: Here the first call is reaching msvc-b but the second one is
        // is reaching msvc-c
        callingMsvcB();

        callingMsvcC();
    }

    private void callingMsvcB() {

        String url = msvcBUrl;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        HttpEntity<?> httpRequest = getHttpEntity();

        LOGGER.info("Calling [{}]", uriBuilder.build().encode().toUriString());

        ResponseEntity<String> response = template.exchange(uriBuilder.build().encode().toUri(),
                HttpMethod.GET, httpRequest, String.class);
    }

    private void callingMsvcC() {

        String url = msvcCUrl;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        HttpEntity<?> httpRequest = getHttpEntity();

        LOGGER.info("Calling [{}]", uriBuilder.build().encode().toUriString());

        ResponseEntity<String> response = template.exchange(uriBuilder.build().encode().toUri(),
                HttpMethod.GET, httpRequest, String.class);
    }
}
