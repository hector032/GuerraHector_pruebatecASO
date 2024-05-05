package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationsAmount {

    public enum Currency {
        MXN,
        EUR
    }

    private int amountt;
    private Currency currencyy;
}
