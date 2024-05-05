package com.bbva.uuaa.helloWorld.business.v0.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BCreateUser {
    private String name;
    private String surname;
    private BIdentityDocuments identityDocuments;
}
