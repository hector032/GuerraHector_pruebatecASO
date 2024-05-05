package com.bbva.uuaa.helloWorld.facade.v0.dto;


import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateOffer {
    private String id;
    private String nuip;
    @Pattern(regexp = "[A-Z_]+",message = "debe ser en mayusculas")
    private String offerType;
    @Valid
    private LimitAmount limitAmount;
    @Valid
    private Product product;
    private MaximumAmount maximumAmount;
    private MinimumAmount minimumAmount;



}
