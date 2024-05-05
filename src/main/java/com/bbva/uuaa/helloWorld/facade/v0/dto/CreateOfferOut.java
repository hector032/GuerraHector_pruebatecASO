package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateOfferOut {

    private String id;
    private String nuip;
    private String offerType;
    private LimitAmount limitAmount;
    private Product product;
    private MaximumAmount maximumAmount;
    private MinimumAmount minimumAmount;

}
