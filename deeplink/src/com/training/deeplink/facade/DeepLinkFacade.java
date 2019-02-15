package com.training.deeplink.facade;

import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.data.FormDeepLinkData;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface DeepLinkFacade {

    List<DeepLinkSummaryData> getDeepLinks();

    List<DeepLinkSummaryData> getDeepLinksByProduct(ProductModel productModel);

    List<DeepLinkSummaryData> getVerifiedDeepLinksByProduct(ProductModel productModel);

    void saveDeepLink(FormDeepLinkData deepLink);
}
