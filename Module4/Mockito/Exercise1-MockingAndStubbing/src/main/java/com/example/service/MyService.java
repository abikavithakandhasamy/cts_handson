package com.example.service;

import com.example.api.ExternalApi;

public class MyService {

    private ExternalApi externalApi;

    // Constructor Injection
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}