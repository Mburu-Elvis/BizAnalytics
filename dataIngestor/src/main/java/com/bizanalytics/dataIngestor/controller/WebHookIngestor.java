package com.bizanalytics.dataIngestor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/webhook")
public class WebHookIngestor {

    @PostMapping()
    public void apiWebhook() {

    }
}
