package com.training.deeplink.attributeHandler;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

public class DeepLinkCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {

    @Override
    public Integer get(ProductModel model) {
        return model.getDeepLinks().size();
    }
}
