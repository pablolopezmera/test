package com.ec.virtualcoin.commmon;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/quotation")
public class QuotationService extends Application {

    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Path("/btc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response btcQuotation() {
        CoinmarketClient client  = new CoinmarketClient();
        try {
            Quote quote = client.getBtcQuotation();
            ObjectMapper mapper = new ObjectMapper();
            String asString = mapper.writeValueAsString(quote);
            return Response.ok(asString).build();
        } catch (IOException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
}
