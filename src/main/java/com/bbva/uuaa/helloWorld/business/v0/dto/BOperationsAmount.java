package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BOperationsAmount {

    public enum Currency {
        MXN,
        EUR
    }

    private int amountt;
    private Currency currencyy;
}
