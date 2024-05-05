package com.bbva.uuaa.helloWorld.facade.v0.mapper.impl;

import com.bbva.uuaa.helloWorld.facade.v0.dto.ClaimAmount;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoIn;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.Hello;
import com.bbva.uuaa.helloWorld.facade.v0.dto.OperationStatus;
import com.bbva.uuaa.helloWorld.facade.v0.dto.OperationsAmount;
import org.springframework.stereotype.Component;

@Component(value = "srvHelloWorldMapper")
public class SrvHelloWorldMapper {

    /*
    //@Override
    public Hello mapIn(DtoIn dtoIn) {
        Hello hello = new Hello();
        hello.setMessage(dtoIn.getName()+dtoIn.getSurname()+dtoIn.getEmail());
        if(dtoIn.getAddress() != null){
            hello.setMessage(dtoIn.getName()+dtoIn.getSurname()+dtoIn.getEmail()+dtoIn.getAddress());
        }
        return hello;
    }

    //@Override
    public DtoOut mapOut(Hello hello) {
        DtoOut dtoOut = new DtoOut();
        dtoOut.setMessage(hello.getMessage());
        return dtoOut;
    }

    */

    public Hello mapIn(DtoIn dtoIn) {
        Hello hello = new Hello();

        OperationStatus operationStatus = new OperationStatus();
        operationStatus.setId(dtoIn.getOperationStatus().getId());

        hello.setId(operationStatus);

        return hello;
    }

    //@Override
    public DtoOut mapOut(Hello hello) {
        DtoOut dtoOut = new DtoOut();
        //dtoOut.setMessage(hello.getMessage());
        OperationStatus operationStatus = new OperationStatus();


        operationStatus.setId(hello.getId().getId());
        dtoOut.setOperationStatus(operationStatus);

        dtoOut.setOperationsNumber(hello.getOperationsNumber());

        ClaimAmount claimAmount = new ClaimAmount();
        claimAmount.setAmount(hello.getAmount().getAmount());
        claimAmount.setCurrency(hello.getCurrency().getCurrency());
        dtoOut.setClaimAmount(claimAmount);

        OperationsAmount operationsAmount = new OperationsAmount();
        operationsAmount.setAmountt(hello.getAmountt().getAmountt());
        operationsAmount.setCurrencyy(hello.getCurrencyy().getCurrencyy());
        dtoOut.setOperationsAmount(operationsAmount);

        return dtoOut;
    }




}
