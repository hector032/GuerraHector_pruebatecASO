package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateLoan {

    @NotNull
    private String id;
    private String loanId;
    @Valid
    private IncomeValues incomeValues;

}
