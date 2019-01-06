package com.ec.virtualcoin.common;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ec.virtualcoin.config.CoinaturalConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

@Component(immediate = true, service = Application.class, configurationPid = "com.ec.virtualcoin.config.CoinaturalConfiguration")
@ApplicationPath("/quotation")
public class QuotationService extends Application {
    
    private static Logger _logger = LoggerFactory.getLogger(QuotationService.class.getName());

    private volatile CoinaturalConfiguration _configuration;

    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Path("/btc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response btcQuotation(@Context HttpServletRequest request) {
        
        Double transactionFee = _configuration.transactionFee();
        
        CoinmarketClient client  = new CoinmarketClient(transactionFee);
        try {
            Quote quote = client.getBtcQuotation();
            ObjectMapper mapper = new ObjectMapper();
            String asString = mapper.writeValueAsString(quote);
            return Response.ok(asString).build();
        } catch (IOException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _logger.info("Se activa o modifica..." + properties);
        _configuration = ConfigurableUtil.createConfigurable(CoinaturalConfiguration.class, properties);
    }

}
