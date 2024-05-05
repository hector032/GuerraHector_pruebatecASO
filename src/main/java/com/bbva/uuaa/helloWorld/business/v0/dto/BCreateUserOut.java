package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserOut {
    private String name;
    private String surname;
    private String documentNumber;
    private String documentType;
}
