package com.jlopezv.async.controller;

import com.jlopezv.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping(value = "/testAsync")
    public CompletableFuture<String> testAsync() throws InterruptedException {

        return asyncService.getEmployeeName().thenApply(s -> s);

    }
}
