package com.training.deeplink.daos;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface ProductDAO {

    List<ProductModel> findProductsByCode(String code);

}
