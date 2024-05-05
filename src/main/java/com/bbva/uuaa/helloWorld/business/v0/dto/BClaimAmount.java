package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BClaimAmount {
    public enum Currency {
        MXN,
        EUR
    }


    private Currency currency;
    private int amount;


}

