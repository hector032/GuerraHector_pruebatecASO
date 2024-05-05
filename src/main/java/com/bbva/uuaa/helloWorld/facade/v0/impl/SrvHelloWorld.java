package com.bbva.uuaa.helloWorld.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreated;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseNoContent;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.uuaa.helloWorld.business.v0.IBSrvHelloWorld;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoan;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateLoanOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOffer;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateOfferOut;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUser;
import com.bbva.uuaa.helloWorld.business.v0.dto.BCreateUserOut;
import com.bbva.uuaa.helloWorld.facade.v0.ISrvHelloWorld;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateLoan;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateLoanOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateOffer;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateOfferOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateUser;
import com.bbva.uuaa.helloWorld.facade.v0.dto.CreateUserOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoIn;
import com.bbva.uuaa.helloWorld.facade.v0.dto.DtoOut;
import com.bbva.uuaa.helloWorld.facade.v0.dto.Hello;
import com.bbva.uuaa.helloWorld.facade.v0.mapper.ISrvHelloWorldMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service
@SN(registryID = "SN000000001", logicalID = "helloWorld")
@VN(vnn = "v0")
@Path("/v0")
public class SrvHelloWorld implements ISrvHelloWorld {
    //private final ISrvHelloWorldMapper mapper;
    //public SrvHelloWorld(ISrvHelloWorldMapper mapper) {
    //	this.mapper = mapper;
    //}
    //
    //@Autowired
    //private ISrvHelloWorldMapper mapper;
    //@Resource(name = "srvHelloWorldMapper")
    //private ISrvHelloWorldMapper mapper;


    /*
        @Override
        @GET
        @Path("/hello")
        @Produces({MediaType.APPLICATION_JSON})
        @SMC(registryID = "SMC000000001", logicalID = "hello")
        public ServiceResponse<Hello> helloWorld() {
            Hello hello = new Hello();
            hello.setMessage("Hello World!");
            return ServiceResponse.data(hello).build();
        }
    */
    //GET DEL EJERCICIO
	/*@Override
	@GET
	@Path("/1/operations-status-summary")
	@Produces({MediaType.APPLICATION_JSON})
	@SMC(registryID = "SMC000000001", logicalID = "request-claims")
	public ServiceResponse<Hello> helloWorld() {
		Hello hello = new Hello();
		hello.setMessage("Hello World!");

		OperationStatus operationStatus = new OperationStatus();
		operationStatus.setId(OperationStatus.Status.APPROVED);
		hello.setId(operationStatus);

		hello.setOperationsNumber("5");

		ClaimAmount claimAmount = new ClaimAmount();
		claimAmount.setAmount(250);
		claimAmount.setCurrency(ClaimAmount.Currency.MXN);
		hello.setAmount(claimAmount);

		OperationsAmount operationsAmount = new OperationsAmount();
		operationsAmount.setAmountt(300);
		operationsAmount.setCurrencyy(OperationsAmount.Currency.MXN);
		hello.setAmountt(operationsAmount);

		return ServiceResponse.data(hello).build();

	}*/

    @Resource(name = "bSrvHelloWorld")
    private IBSrvHelloWorld business;


    @Override
    @GET
    @Path("/request-claims/{request-claim-id}/operations-status-summary")
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000030", logicalID = "request_claim")
    public ServiceResponse<DtoOut> requestClaim(@PathParam("request-claim-id") String request) {
        ISrvHelloWorldMapper mapper = Mappers.getMapper(ISrvHelloWorldMapper.class);
        //String bRequest = mapper.mapInRequestClaim(request);
        //BDtoOut bDtoOut = business.mapBusinessGet(bRequest);
        //DtoOut requestC = mapper.mapOutRequestClaim(bDtoOut);
        // resumido en una linea
        //DtoOut dtoOut = mapper.mapOutRequestClaim(business.mapBusinessGet(mapper.mapInRequestClaim(request)));
        // mas resumido (nos ahorramos convertir String to String)
        DtoOut dtoOut = mapper.mapOutRequestClaim(business.mapBusinessGet(request));
        return ServiceResponse.data(dtoOut).build();
    }


    @Override
    @POST
    @Path("/createLoan")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000043", logicalID = "createLoan")
    public ServiceResponseCreated<CreateLoanOut> createLoan(@Valid CreateLoan createLoan) {
        //solo cuando usemos mappstruck (sino se usaria autowired etc(pryectos viejos))
        ISrvHelloWorldMapper mapper = Mappers.getMapper(ISrvHelloWorldMapper.class);
        //ahora toca business(xq ya estamos en facade (orden=>facade-business))
        // Instanciamos business
        BCreateLoan bCreateLoan = mapper.mapInCreateLoan(createLoan);
        BCreateLoanOut bCreateLoanOut = business.businessLoan(bCreateLoan);
        CreateLoanOut createLoanOut = mapper.mapOutLoan(bCreateLoanOut);

        //lo hacemos en una sola linea
        //CreateLoanOut createLoanOut = mapper.mapOutLoan(business.businessLoan(mapper.mapInCreateLoan(createLoan)));

        return ServiceResponseCreated.data(createLoanOut).build();

    }

    @Override
    @POST
    @Path("/simulations/{nuip}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000045", logicalID = "createOffers")
    public ServiceResponseCreated<CreateOfferOut> createOffer(@Valid CreateOffer createOffer, @PathParam("nuip") String nuip) {
        ISrvHelloWorldMapper mapper = Mappers.getMapper(ISrvHelloWorldMapper.class);
        BCreateOffer bCreateOffer = mapper.mapInCreateOffer(createOffer);
        BCreateOfferOut bCreateOfferOut = business.businessOffer(bCreateOffer);
        CreateOfferOut createOfferOut = mapper.mapOutOffer(bCreateOfferOut);
        createOfferOut.setNuip(nuip);
        return ServiceResponseCreated.data(createOfferOut).build();
    }


    @Override
    @GET
    @Path("/request-claims/{request-claim-id}/operations-status-summary")
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000001", logicalID = "hello")
    public ServiceResponse<Hello> helloWorld() {
        Hello hello = new Hello();
        hello.setMessage("Hello World!");
        return ServiceResponse.data(hello).build();
    }


    //mapper = Mappers.getMapper(ISrvHelloWorldMapper.class);

    @Override
    @POST
    @Path("/helloMapper")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000033", logicalID = "helloMapper")
    public ServiceResponse<DtoOut> helloWorldMapper(DtoIn dtoIn) {
        DtoOut dtoOut = new DtoOut();
        Hello hello = new Hello();
        //hello = mapper.mapIn(dtoIn);
        //dtoOut = mapper.mapOut(hello);
        return ServiceResponse.data(dtoOut).build();
    }

    @Override
    @POST
    @Path("/hello")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000002", logicalID = "helloPost")
    public ServiceResponseCreated helloWorldPost(Hello hello) {
        return ServiceResponseCreated.data(hello).build();
    }


    @Override
    @POST
    @Path("/createUser")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000020", logicalID = "createUser")
    public ServiceResponseCreated<BCreateUser> createUser(@Valid CreateUser user) {
        ISrvHelloWorldMapper mapper = Mappers.getMapper(ISrvHelloWorldMapper.class);
        BCreateUser bCreateUser = mapper.mapInCreateUser(user);
        BCreateUserOut bCreateUserOut = business.mapBusiness(bCreateUser);
        CreateUserOut createUserOut = mapper.mapOutCreateUser(bCreateUserOut);
        return ServiceResponseCreated.data(createUserOut).build();
    }


    @Override
    @PUT
    @Path("/hello")
    @Consumes({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000003", logicalID = "helloPut")
    public ServiceResponseNoContent helloWorldPut(Hello hello) { // Esto manda un message
        return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
    }

    @Override
    @DELETE
    @Path("/hello")
    @Consumes({MediaType.APPLICATION_JSON})
    @SMC(registryID = "SMC000000004", logicalID = "helloDelete")
    public ServiceResponse.ServiceResponseBuilder helloWorldDelete(Hello hello) {
        return ServiceResponse.data(null);
    }
}
