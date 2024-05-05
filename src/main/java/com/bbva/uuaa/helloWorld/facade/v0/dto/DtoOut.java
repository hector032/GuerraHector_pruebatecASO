package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class DtoOut {
    //private String message;
    private OperationStatus operationStatus;
    private int operationsNumber;
    private ClaimAmount claimAmount;
    private OperationsAmount operationsAmount;
}
