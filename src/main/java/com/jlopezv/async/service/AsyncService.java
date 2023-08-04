package com.jlopezv.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public CompletableFuture<String> getEmployeeName() throws InterruptedException
    {
        log.info("getEmployeeName starts");

        AsyncObject asyncObject = new AsyncObject("value");

        log.info("asyncObject, {}", asyncObject);
        Thread.sleep(1000L);  //Intentional delay
        log.info("employeeNameData completed");
        return CompletableFuture.completedFuture(asyncObject.getValue());
    }


}

class AsyncObject {
    private final String value;

    public AsyncObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
