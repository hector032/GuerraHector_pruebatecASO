package com.bbva.uuaa.helloWorld.business.v0.dto;

import com.bbva.uuaa.helloWorld.facade.v0.dto.IncomeValues;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BCreateLoan {

    @NotNull
    private String id;
    private String loanId;
    private BIncomeValues incomeValues;

}
