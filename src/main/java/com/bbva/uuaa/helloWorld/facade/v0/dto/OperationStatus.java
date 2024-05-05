package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OperationStatus {

    public enum Status {
        APPROVED,
        DENIED
    }

    private Status id;

}
