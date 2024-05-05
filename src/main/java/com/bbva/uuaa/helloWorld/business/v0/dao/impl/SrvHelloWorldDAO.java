package com.bbva.uuaa.helloWorld.business.v0.dao.impl;

import com.bbva.uuaa.helloWorld.business.v0.dao.ISrvHelloWorldDAO;
import com.bbva.uuaa.helloWorld.business.v0.dto.BClaimAmount;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoan;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoanOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOffer;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOfferOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUserOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDtoOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BIncomeValues;
import com.bbva.uuaa.helloWorld.business.v0.dto.BLimitAmount;
import com.bbva.uuaa.helloWorld.business.v0.dto.BMaximumAmount;
import com.bbva.uuaa.helloWorld.business.v0.dto.BMinimumAmount;
import com.bbva.uuaa.helloWorld.business.v0.dto.BOperationStatus;
import com.bbva.uuaa.helloWorld.business.v0.dto.BOperationsAmount;
import com.bbva.uuaa.helloWorld.business.v0.dto.BProduct;
import com.bbva.uuaa.helloWorld.business.v0.dto.BSubProduct;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "srvHelloWorldDAO")
public class SrvHelloWorldDAO implements ISrvHelloWorldDAO {
    @Override
    public BCreateUserOut map(BCreateUser bCreateUser) {
        BCreateUserOut bCreateUserOut = new BCreateUserOut();

        if(validateObject(bCreateUser)){
            return null;
        }
        bCreateUserOut.setName(bCreateUser.getName());
        bCreateUserOut.setSurname(bCreateUser.getSurname());
        bCreateUserOut.setDocumentNumber(bCreateUser.getIdentityDocuments().getDocumentNumber());
        bCreateUserOut.setDocumentType(bCreateUser.getIdentityDocuments().getDocumentType());
        return bCreateUserOut;
        }

        //GET
    @Override
    public BDtoOut mapDaoGet(String bRequest) {
        BDtoOut bDtoOut = new BDtoOut();

        BOperationStatus operationStatus = new BOperationStatus();
        operationStatus.setId(BOperationStatus.Status.APPROVED);
        bDtoOut.setOperationStatus(operationStatus);

        bDtoOut.setOperationsNumber(5);

        BClaimAmount claimAmount = new BClaimAmount();
        claimAmount.setAmount(250);
        claimAmount.setCurrency(BClaimAmount.Currency.MXN);
        bDtoOut.setClaimAmount(claimAmount);

        BOperationsAmount operationsAmount = new BOperationsAmount();
        operationsAmount.setAmountt(300);
        operationsAmount.setCurrencyy(BOperationsAmount.Currency.MXN);
        bDtoOut.setOperationsAmount(operationsAmount);

        return bDtoOut;
    }

        //POST
    @Override
    public BCreateLoanOut mapLoan(BCreateLoan bCreateLoan) {
        BCreateLoanOut  bCreateLoanOut = new BCreateLoanOut();

        bCreateLoanOut.setId(bCreateLoan.getId());
        bCreateLoanOut.setLoanId(bCreateLoan.getLoanId());

        BIncomeValues bIncomeValues = new BIncomeValues();

        bIncomeValues.setAmount(bCreateLoan.getIncomeValues().getAmount());
        bIncomeValues.setCurrency(bCreateLoan.getIncomeValues().getCurrency());

        bCreateLoanOut.setIncomeValues(bIncomeValues);
        return bCreateLoanOut;
    }
    //Metodo para generar caracteres aleatorios
    public String generateRandomId(int rango) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomId = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < rango; i++) {
            int index = random.nextInt(characters.length());
            randomId.append(characters.charAt(index));
        }
        return randomId.toString();
    }

    @Override
    public BCreateOfferOut mapOffer(BCreateOffer bCreateOffer) {

        BCreateOfferOut bCreateOfferOut = new BCreateOfferOut();
        String randomId = generateRandomId(10);
        bCreateOfferOut.setId(randomId);
        bCreateOfferOut.setOfferType(bCreateOffer.getOfferType());

        BLimitAmount bLimitAmount = new BLimitAmount();
        bLimitAmount.setAmount(bCreateOffer.getLimitAmount().getAmount());
        bLimitAmount.setCurrency(bCreateOffer.getLimitAmount().getCurrency());
        bCreateOfferOut.setLimitAmount(bLimitAmount);

        BProduct bProduct = new BProduct();
        bProduct.setId(bCreateOffer.getProduct().getId());

        BSubProduct bSubProduct = new BSubProduct();
        bSubProduct.setId(bCreateOffer.getProduct().getSubProduct().getId());

        bProduct.setSubProduct(bSubProduct);

        bCreateOfferOut.setProduct(bProduct);

        double limitAmount = bCreateOffer.getLimitAmount().getAmount().doubleValue();
        double minAmount = limitAmount - (limitAmount * 0.10);
        double maxAmount = limitAmount + (limitAmount * 0.05);

        BMinimumAmount bMinimumAmount = new BMinimumAmount();
        BMaximumAmount bMaximumAmount = new BMaximumAmount();


        bMinimumAmount.setAmount(minAmount);
        bMinimumAmount.setCurrency(bCreateOffer.getLimitAmount().getCurrency());
        bMaximumAmount.setAmount(maxAmount);
        bMaximumAmount.setCurrency(bCreateOffer.getLimitAmount().getCurrency());

        bCreateOfferOut.setMinimumAmount(bMinimumAmount);
        bCreateOfferOut.setMaximumAmount(bMaximumAmount);

        return bCreateOfferOut;
    }

    /***
        * Malas prácticas por if dentro de if
        *
        *
        if (bCreateUser != null) {
            bCreateUserOut.setName(bCreateUserOut.getName());
            bCreateUserOut.setSurname(bCreateUserOut.getSurname());
            if (bCreateUser.getIdentityDocuments() != null) {
                bCreateUserOut.setDocumentNumber(bCreateUser.getIdentityDocuments().getDocumentNumber());
                bCreateUserOut.setDocumentType(bCreateUser.getIdentityDocuments().getDocumentType());
            }
            return bCreateUserOut;
        }
        return null;
    }
    */
       private boolean validateObject(BCreateUser bCreateUser){
           return bCreateUser == null || bCreateUser.getIdentityDocuments() == null;
       }
}
