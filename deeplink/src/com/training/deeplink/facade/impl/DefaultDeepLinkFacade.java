package com.training.deeplink.facade.impl;

import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.data.FormDeepLinkData;
import com.training.deeplink.facade.DeepLinkFacade;
import com.training.deeplink.model.DeepLinkModel;
import com.training.deeplink.service.DeepLinkService;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultDeepLinkFacade implements DeepLinkFacade {

    private DeepLinkService deepLinkService;

    private ModelService modelService;

    private AbstractPopulatingConverter<DeepLinkModel, DeepLinkSummaryData> converter;
    private AbstractPopulatingConverter<FormDeepLinkData, DeepLinkModel> reverseConverter;

    @Override
    public List<DeepLinkSummaryData> getDeepLinks() {
        return modelListToDataList(deepLinkService.getDeepLinks());
    }

    @Override
    public List<DeepLinkSummaryData> getDeepLinksByProduct(ProductModel productModel) {
        return modelListToDataList(deepLinkService.getDeepLinksByProduct(productModel));
    }

    @Override
    public List<DeepLinkSummaryData> getVerifiedDeepLinksByProduct(ProductModel productModel) {
        return modelListToDataList(deepLinkService.getVerifiedDeepLinksByProduct(productModel));
    }

    private List<DeepLinkSummaryData> modelListToDataList(List<DeepLinkModel> models){
        return models.stream().map(this::modelToData).collect(Collectors.toList());
    }

    private DeepLinkSummaryData modelToData(DeepLinkModel deepLinkModel){
        return converter.convert(deepLinkModel);
    }

    @Override
    public void saveDeepLink(FormDeepLinkData deepLink) {
        DeepLinkModel target = modelService.create(DeepLinkModel.class);
        reverseConverter.populate(deepLink, target);
        deepLinkService.saveDeepLink(target);
    }

    public DeepLinkService getDeepLinkService() {
        return deepLinkService;
    }

    public void setDeepLinkService(DeepLinkService deepLinkService) {
        this.deepLinkService = deepLinkService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public AbstractPopulatingConverter<DeepLinkModel, DeepLinkSummaryData> getConverter() {
        return converter;
    }

    public void setConverter(AbstractPopulatingConverter<DeepLinkModel, DeepLinkSummaryData> converter) {
        this.converter = converter;
    }

    public AbstractPopulatingConverter<FormDeepLinkData, DeepLinkModel> getReverseConverter() {
        return reverseConverter;
    }

    public void setReverseConverter(AbstractPopulatingConverter<FormDeepLinkData, DeepLinkModel> reverseConverter) {
        this.reverseConverter = reverseConverter;
    }
}
