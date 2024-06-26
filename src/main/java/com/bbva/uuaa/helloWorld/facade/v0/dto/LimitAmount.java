package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LimitAmount {

    @NotNull
    private Number amount;
    @NotNull
    @NotEmpty
    private String currency;

}
