package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimAmount {
    public enum Currency {
        MXN,
        EUR
    }


    private Currency currency;
    private int amount;


}

