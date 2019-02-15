package com.training.deeplink.populator;

import com.training.deeplink.daos.ProductDAO;
import com.training.deeplink.data.FormDeepLinkData;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;

public class ReverseDeepLinkPopulator implements Populator<FormDeepLinkData, DeepLinkModel> {

    private ProductDAO productDAO;


    /**
     * Populate the target instance with values from the source instance.
     *
     * @param newDeepLinkData the source object
     * @param deepLinkModel   the target to fill
     * @throws ConversionException if an error occurs
     */
    @Override
    public void populate(FormDeepLinkData newDeepLinkData, DeepLinkModel deepLinkModel) throws ConversionException {
        deepLinkModel.setCode(generateCode());
        deepLinkModel.setName(newDeepLinkData.getName());
        deepLinkModel.setUrl(newDeepLinkData.getUrl());

        deepLinkModel.setProducts(new HashSet<>(productDAO.findProductsByCode(newDeepLinkData.getProductCode())));
    }

    private String generateCode() {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
