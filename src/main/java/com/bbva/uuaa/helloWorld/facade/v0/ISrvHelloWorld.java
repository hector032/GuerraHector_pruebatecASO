package com.bbva.uuaa.helloWorld.facade.v0;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreated;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseNoContent;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateLoan;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateLoanOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateOffer;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateOfferOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateUser;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoIn;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.Hello;

import javax.validation.Valid;
import javax.ws.rs.PathParam;

public interface ISrvHelloWorld {
	
	ServiceResponse<Hello> helloWorld ();
	ServiceResponseCreated<Hello> helloWorldPost(Hello hello);
	ServiceResponseNoContent helloWorldPut(Hello hello);
	ServiceResponse.ServiceResponseBuilder helloWorldDelete(Hello hello);
	ServiceResponse<DtoOut> helloWorldMapper(DtoIn dtoIn);
	ServiceResponse<BCreateUser> createUser(CreateUser createUser);

	ServiceResponse<DtoOut> requestClaim(String request);

	//Usualmente para post (devuelve 201 created)
	ServiceResponseCreated<CreateLoanOut> createLoan(CreateLoan createLoan);

	//ServiceResponseCreated<CreateOfferOut> createOffer(CreateOffer createOffer);

	ServiceResponseCreated<CreateOfferOut> createOffer(CreateOffer createOffer, String nuip);

}
