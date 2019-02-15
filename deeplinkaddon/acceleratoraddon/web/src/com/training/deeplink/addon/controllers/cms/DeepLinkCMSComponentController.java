package com.training.deeplink.addon.controllers.cms;


import com.training.deeplink.addon.controllers.DeeplinkaddonControllerConstants;
import com.training.deeplink.addon.model.DeepLinkCMSComponentModel;
import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.data.FormDeepLinkData;
import com.training.deeplink.facade.DeepLinkFacade;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("DeepLinkCMSComponentController")
@RequestMapping(value = DeeplinkaddonControllerConstants.Actions.Cms.DeepLinkCMSComponent)
public class DeepLinkCMSComponentController extends AbstractCMSAddOnComponentController<DeepLinkCMSComponentModel> {

    private DeepLinkFacade deepLinkFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, DeepLinkCMSComponentModel component) {
        ProductModel product = getRequestContextData(request).getProduct();
        List<DeepLinkSummaryData> deepLinks = deepLinkFacade.getVerifiedDeepLinksByProduct(product);
        model.addAttribute("deepLinks", deepLinks);
        model.addAttribute("deepLink", new FormDeepLinkData());
    }

    @PostMapping
    @ResponseBody
    public String addDeeplink(@RequestBody FormDeepLinkData deepLink, BindingResult result) {
        if (!result.hasErrors()) {
            deepLinkFacade.saveDeepLink(deepLink);
            return "ok";
        } else {
            return "error";
        }
    }

    @PostMapping(value = "/addLink")
    @ResponseBody
    public String addDeeplink2( FormDeepLinkData deepLink, BindingResult result) {
        if (!result.hasErrors()) {
            deepLinkFacade.saveDeepLink(deepLink);
            return "ok";
        } else {
            return "error";
        }
    }

    public DeepLinkFacade getDeepLinkFacade() {
        return deepLinkFacade;
    }

    public void setDeepLinkFacade(DeepLinkFacade deepLinkFacade) {
        this.deepLinkFacade = deepLinkFacade;
    }
}
