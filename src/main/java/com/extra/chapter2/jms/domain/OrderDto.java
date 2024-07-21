package com.extra.chapter2.jms.domain;

public class OrderDto {
    private int number;
    private float price;
    private String customerInfo;
    private String status;

    public OrderDto(int number, float price, String customerInfo, String status) {
        this.number = number;
        this.price = price;
        this.customerInfo = customerInfo;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public String getStatus() {
        return status;
    }
}
