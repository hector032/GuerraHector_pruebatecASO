package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BDtoOut {
    //private String message;
    private BOperationStatus operationStatus;
    private int operationsNumber;
    private BClaimAmount claimAmount;
    private BOperationsAmount operationsAmount;


}
