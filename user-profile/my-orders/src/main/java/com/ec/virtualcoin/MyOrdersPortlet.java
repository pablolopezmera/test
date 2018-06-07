package com.ec.virtualcoin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import user.profile.model.Purchase;
import user.profile.service.PurchaseLocalServiceUtil;

@Component(
        immediate = true,
        property = {
            "com.liferay.portlet.add-default-resource=true",
            "com.liferay.portlet.css-class-wrapper=portlet-controlpanel",
            "com.liferay.portlet.display-category=category.hidden",
            "com.liferay.portlet.preferences-owned-by-group=true",
            "com.liferay.portlet.render-weight=100",
            "javax.portlet.display-name=My Orders",
            "javax.portlet.expiration-cache=0",
            "javax.portlet.init-param.view-template=/view.jsp",
            "javax.portlet.name=my_orders",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=administrator",
            "javax.portlet.supports.mime-type=text/html"
        },
        service = Portlet.class
    )
public class MyOrdersPortlet extends MVCPortlet {

    private static Logger _logger = LoggerFactory.getLogger(MyOrdersPortlet.class.getName());

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        System.out.println("---------------------------------------------");
        _logger.info("renderrrrrrrrrr");
        String screenName;
        try {
            screenName = PortalUtil.getUser(renderRequest).getScreenName();
            List<PurchaseDto> orders = loadUserOrders(screenName);
            Escaper escaper = new Escaper(ordersToJsonString(orders).toJSONString());
            String unescaped = escaper.unescape();
            _logger.info(unescaped);
            _logger.info("size: " + orders.size());
            renderRequest.setAttribute("orders", unescaped);
            super.render(renderRequest, renderResponse);
        } catch (PortalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private JSONArray ordersToJsonString(List<PurchaseDto> orders) {

        JSONArray resultsArray = JSONFactoryUtil.createJSONArray();

        if (orders != null) {

            for (PurchaseDto user : orders) {
                JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();
                resultsArray.put(serializer.serialize(user));
            }
        }
        return resultsArray;
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        // TODO Auto-generated method stub
        _logger.info("do viewwwwwwwwwwwwwwwwwww");
        super.doView(renderRequest, renderResponse);
    }

    private List<PurchaseDto> loadUserOrders(String screenName) {
        List<PurchaseDto> userList = new ArrayList<>();
        List<Purchase> orders = PurchaseLocalServiceUtil.findByscreenname(screenName);
        for (Purchase p : orders) {
            userList.add(new PurchaseDto(p.getCurr_from(), p.getCurr_to(), p.getDate_time(), p.getEwallet(),
                    p.getValue_from(), p.getValue_to()));
        }
        _logger.info("Users: " + orders.size());
        return userList;
    }

}