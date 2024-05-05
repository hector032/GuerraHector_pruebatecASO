package com.bbva.uuaa.helloWorld.facade.v0.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Hello implements Serializable {
	
	String message;
	OperationStatus id;
	int operationsNumber;
	ClaimAmount amount;
	ClaimAmount currency;
	OperationsAmount amountt;
	OperationsAmount currencyy;
}
