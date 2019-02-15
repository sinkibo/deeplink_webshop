package com.training.deeplink.daos.impl;

import com.training.deeplink.daos.ProductDAO;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

public class DefaultProductDAO implements ProductDAO {

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<ProductModel> findProductsByCode(String code) {
        final String queryString = //
                "SELECT {p:" + ProductModel.PK + "}" //
                        + "FROM {" + ProductModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + ProductModel.CODE + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.<ProductModel> search(query).getResult();
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
