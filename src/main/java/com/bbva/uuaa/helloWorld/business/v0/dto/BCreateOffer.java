package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BCreateOffer {

    private String id;
    private String nuip;
    private String offerType;
    private BLimitAmount limitAmount;
    private BProduct product;
    private BMaximumAmount maximumAmount;
    private BMinimumAmount minimumAmount;


}
