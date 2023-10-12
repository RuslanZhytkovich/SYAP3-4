package com.lab3.lab3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RequestHistory {
    public RequestHistory(Long id, String requestTime, String responseTime, long executionTime) {
        this.id = id;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
        this.executionTime = executionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public RequestHistory()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestTime;
    private String responseTime;
    private long executionTime;



    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
