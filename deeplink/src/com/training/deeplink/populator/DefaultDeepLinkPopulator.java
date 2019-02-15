package com.training.deeplink.populator;

import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class DefaultDeepLinkPopulator implements Populator<DeepLinkModel, DeepLinkSummaryData> {
    /**
     * Populate the target instance with values from the source instance.
     *
     * @param deepLinkModel       the source object
     * @param deepLinkSummaryData the target to fill
     * @throws ConversionException if an error occurs
     */
    @Override
    public void populate(DeepLinkModel deepLinkModel, DeepLinkSummaryData deepLinkSummaryData) throws ConversionException {
        deepLinkSummaryData.setUrl(deepLinkModel.getUrl());
        deepLinkSummaryData.setName(deepLinkModel.getName());
        deepLinkSummaryData.setCode(deepLinkModel.getCode());
    }
}
