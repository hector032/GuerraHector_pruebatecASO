package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SubProduct {
    @Pattern(regexp = "^.{0,2}$", message = "debe contener entre 0 y 2 caracteres")
    private String id;

}
