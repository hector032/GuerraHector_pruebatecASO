package com.bbva.uuaa.helloWorld.business.v0;

import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoan;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoanOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOffer;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOfferOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUserOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BDtoOut;


public interface IBSrvHelloWorld {
    BCreateUserOut mapBusiness(BCreateUser bCreateUser);
    BDtoOut mapBusinessGet(String bRequest);
    BCreateLoanOut businessLoan(BCreateLoan bCreateLoan);
    BCreateOfferOut businessOffer(BCreateOffer bCreateOffer);


}
