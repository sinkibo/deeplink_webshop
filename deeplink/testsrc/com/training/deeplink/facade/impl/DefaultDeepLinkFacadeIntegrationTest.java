package com.training.deeplink.facade.impl;

import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.facade.DeepLinkFacade;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@IntegrationTest
public class DefaultDeepLinkFacadeIntegrationTest extends ServicelayerTransactionalTest {

    @Resource
    private DeepLinkFacade deepLinkFacade;

    @Resource
    private ModelService modelService;

    private static final String DEEPLINK_NAME = "BEAUTIFUL NAME";
    private static final String DEEPLINK_URL = "http://niceUrl.com";
    private static final String DEEPLINK_CODE = "http://fabulousUrl.com";

    private static ProductModel product;
    private static DeepLinkModel deepLink;


    @Before
    public void setUp() {
        CatalogVersionModel catalogVersionModel = new CatalogVersionModel();
        CatalogModel catalogModel = new CatalogModel();
        catalogModel.setId("electronicsProductCatalog");
        catalogVersionModel.setCatalog(catalogModel);
        catalogVersionModel.setVersion("Online");

        product = modelService.create(ProductModel.class);
        deepLink = modelService.create(DeepLinkModel.class);

        product.setDeepLinks(Collections.singletonList(deepLink));
        product.setName("my product");
        product.setCatalogVersion(catalogVersionModel);
        product.setCode("12345");

        deepLink.setName(DEEPLINK_NAME);
        deepLink.setUrl(DEEPLINK_URL);
        deepLink.setCode(DEEPLINK_CODE);
        deepLink.setProducts(Collections.singleton(product));

        modelService.save(deepLink);
        modelService.save(product);
    }


    @Test
    public void getDeepLinksTest() {
        List<DeepLinkSummaryData> deepLinks = deepLinkFacade.getDeepLinks();

        assertEquals(1, deepLinks.size());

        DeepLinkSummaryData deepLinkSummaryData = deepLinks.get(0);

        assertEquals(deepLink.getUrl(), deepLinkSummaryData.getUrl());
        assertEquals(deepLink.getName(), deepLinkSummaryData.getName());
        assertEquals(deepLink.getCode(), deepLinkSummaryData.getCode());
    }

    @Test
    public void getDeepLinksByProductTest() {
        List<DeepLinkSummaryData> deepLinks = deepLinkFacade.getDeepLinksByProduct(product);

        assertEquals(1, deepLinks.size());

        DeepLinkSummaryData deepLinkSummaryData = deepLinks.get(0);

        assertEquals(deepLink.getUrl(), deepLinkSummaryData.getUrl());
        assertEquals(deepLink.getName(), deepLinkSummaryData.getName());
        assertEquals(deepLink.getCode(), deepLinkSummaryData.getCode());
    }
}