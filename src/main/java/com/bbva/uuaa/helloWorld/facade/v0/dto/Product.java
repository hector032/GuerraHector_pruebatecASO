package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Product {
    @Pattern(regexp = "TDC", message = "debe ser igual a  TDC ")
    private String id;
    @Valid
    private SubProduct subProduct;
}
