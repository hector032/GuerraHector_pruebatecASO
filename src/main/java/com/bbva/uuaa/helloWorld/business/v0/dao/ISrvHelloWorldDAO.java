package com.bbva.uuaa.helloWorld.business.v0.dao;

import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoan;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoanOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOffer;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOfferOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUserOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDtoOut;

public interface ISrvHelloWorldDAO {
    BCreateUserOut map(BCreateUser bCreateUser);
    BDtoOut mapDaoGet(String bRequest);
    BCreateLoanOut mapLoan(BCreateLoan bCreateLoan);
    BCreateOfferOut mapOffer(BCreateOffer bCreateOffer);

}
