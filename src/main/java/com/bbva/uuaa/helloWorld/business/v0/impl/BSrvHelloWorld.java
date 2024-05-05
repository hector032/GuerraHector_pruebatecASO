package com.bbva.uuaa.helloWorld.business.v0.impl;

import com.bbva.uuaa.helloWorld.business.v0.IBSrvHelloWorld;
import com.bbva.uuaa.helloWorld.business.v0.dao.ISrvHelloWorldDAO;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoan;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoanOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOffer;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOfferOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUserOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDtoOut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "bSrvHelloWorld")
public class BSrvHelloWorld implements IBSrvHelloWorld {
    @Resource(name = "srvHelloWorldDAO")
    private ISrvHelloWorldDAO dao;
    @Override
    public BCreateUserOut mapBusiness(BCreateUser bCreateUser) {
        BCreateUserOut bCreateUserOut = new BCreateUserOut();
        bCreateUserOut = dao.map(bCreateUser);
        return bCreateUserOut;
    }

    @Override
    public BDtoOut mapBusinessGet(String bRequest) {

        return dao.mapDaoGet(bRequest);
    }

    @Override
    public BCreateLoanOut businessLoan(BCreateLoan bCreateLoan) {
        BCreateLoanOut bCreateLoanOut = new BCreateLoanOut();
        bCreateLoanOut = dao.mapLoan(bCreateLoan);
        return bCreateLoanOut;
    }

    @Override
    public BCreateOfferOut businessOffer(BCreateOffer bCreateOffer) {
        BCreateOfferOut bCreateOfferOut = new BCreateOfferOut();
        bCreateOfferOut = dao.mapOffer(bCreateOffer);
        return bCreateOfferOut;
    }
}
