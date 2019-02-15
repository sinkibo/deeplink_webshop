package com.training.deeplink.daos.impl;

import com.training.deeplink.enums.Status;
import com.training.deeplink.daos.DeepLinkDAO;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DefaultDeepLinksDAO implements DeepLinkDAO {


    /**
     * Use Hybris FlexibleSearchService for running queries against the database
     */
    private FlexibleSearchService flexibleSearchService;

    private ModelService modelService;

    /**
     * Uses FlexibleSearchService to find all deepLinks.
     *
     * @return list of all deepLinks in the system.
     */
    @Override
    public List<DeepLinkModel> findDeepLinks() {
        //language=FlexibleSearch
        String queryString = "SELECT {d:pk} FROM {DeepLink AS d}";

        FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<DeepLinkModel>search(query).getResult();
    }

    /**
     * Finds all deepLinks with product using FlexibleSearchService.
     *
     * @param productModel the code to search for deepLinks.
     * @return All deepLinks with the given product.
     */
    @Override
    public List<DeepLinkModel> findDeepLinksByProduct(ProductModel productModel) {
        //language=FlexibleSearch
        String queryString = "select {dl.pk} from {Product as p join Product2DeepLink as ptodl on {p.pk}={ptodl.source} join DeepLink as dl on {ptodl.target}={dl.pk}}  where {p.pk}=?product";
        return flexibleSearchService.<DeepLinkModel>search(queryString, Collections.singletonMap("product", productModel)).getResult();
    }

    @Override
    public List<DeepLinkModel> findDeepLinksByStatus(Status status) {
        //language=FlexibleSearch
        String queryString = "SELECT {d.PK} FROM {DeepLink AS d} WHERE ({{SELECT {enum.PK} FROM {Status AS enum} WHERE {enum.code} = ?status}})  = {d.status}";
        return flexibleSearchService.<DeepLinkModel>search(queryString, Collections.singletonMap("status", status.getCode())).getResult();
    }

    @Override
    public List<DeepLinkModel> findDeepLinksByProductAndStatus(ProductModel productModel, Status status) {
        //language=FlexibleSearch
        String queryString = "select {dl.pk} from {Product as p join Product2DeepLink as ptodl on {p.pk}={ptodl.source} join DeepLink as dl on {ptodl.target}={dl.pk}}" +
                "  where {p.pk}=?product AND ({{SELECT {enum.PK} FROM {Status AS enum} WHERE {enum.code} = ?status}})  = {dl.status}";

        HashMap<String, Object> hints = new HashMap<>();
        hints.put("product", productModel);
        hints.put("status", status.getCode());

        return flexibleSearchService.<DeepLinkModel>search(queryString, hints).getResult();
    }

    @Override
    public void saveDeepLink(DeepLinkModel deepLink) {
        if (deepLink != null){
            modelService.save(deepLink);
        }
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
