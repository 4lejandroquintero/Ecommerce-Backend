package com.deval.ecommerce.Backend.domain.model.Paypal;

import lombok.Data;

@Data
public class DataPayment {
    private String method;
    private  String amount;
    private String currency;
    private String description;

}