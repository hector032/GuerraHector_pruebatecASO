package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class DtoIn {
    //@NotNull
    private String name;
    //@NotEmpty
    private String surname;
    //@NotEmpty
    private int cellphone;
    //@NotBlank
    private String address;
    //@NotNull
    //@Pattern(regexp = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}")
    private String email;

    //Datos del GET
    //@NotNull
    //private String requestClaimId;
    //@Valid
    private OperationStatus operationStatus;

    private int operationsNumber;
    //@Valid
    private ClaimAmount claimAmount;
    //@Valid
    private OperationsAmount operationsAmount;




}
