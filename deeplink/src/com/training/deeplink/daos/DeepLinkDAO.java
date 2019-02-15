package com.training.deeplink.daos;

import com.training.deeplink.enums.Status;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface DeepLinkDAO {

    /**
     * Return a list of deepLink models that are currently persisted. If none are found an empty list is returned.
     *
     * @return all the deepLinks in the system
     */
    List<DeepLinkModel> findDeepLinks();


    /**
     * Finds all deepLinks with product. If none is found, an empty list will be returned.
     *
     * @param productModel the code to search for deepLinks.
     * @return All deepLinks with the given product.
     */
    List<DeepLinkModel> findDeepLinksByProduct(ProductModel productModel);

    List<DeepLinkModel> findDeepLinksByStatus(Status status);
    
    List<DeepLinkModel> findDeepLinksByProductAndStatus(ProductModel productModel, Status status);

    void saveDeepLink(DeepLinkModel deepLink);
}
