package com.training.deeplink.facade.impl;

import com.training.deeplink.data.DeepLinkSummaryData;
import com.training.deeplink.model.DeepLinkModel;
import com.training.deeplink.service.DeepLinkService;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultDeepLinkFacadeUnitTest {

    @InjectMocks
    private DefaultDeepLinkFacade deepLinkFacade = new DefaultDeepLinkFacade();

    @Mock
    private DeepLinkService deepLinkService;

    private DeepLinkModel deepLink;
    private ProductModel product;

    private static final String DEEPLINK_URL = "http://url.com";
    private static final String DEEPLINK_CODE = "some code";
    private static final String DEEPLINK_NAME = "mylinkname";


    public void setUp(){
        CatalogVersionModel catalogVersionModel = new CatalogVersionModel();
        CatalogModel catalogModel = new CatalogModel();
        catalogModel.setId("electronicsProductCatalog");
        catalogVersionModel.setCatalog(catalogModel);
        catalogVersionModel.setVersion("Online");

        product = new ProductModel();
        product.setDeepLinks(Collections.singletonList(deepLink));
        product.setName("my productname");
        product.setCatalogVersion(catalogVersionModel);
        product.setCode("12345");

        deepLinkFacade = new DefaultDeepLinkFacade();
        deepLinkFacade.setDeepLinkService(deepLinkService);
        deepLink = new DeepLinkModel();
        deepLink.setUrl(DEEPLINK_URL);
        deepLink.setName(DEEPLINK_NAME);
        deepLink.setCode(DEEPLINK_CODE);

    }

    @Test
    public void getDeepLinks() {
        List<DeepLinkModel> deepLinks = Collections.singletonList(deepLink);
        when(deepLinkService.getDeepLinks()).thenReturn(deepLinks);

        List<DeepLinkSummaryData> result = deepLinkFacade.getDeepLinks();

        DeepLinkSummaryData dto = result.get(0);

        assertEquals(deepLinks.size(), result.size());
        assertEquals(deepLink.getUrl(), dto.getUrl());
        assertEquals(deepLink.getName(), dto.getName());
        assertEquals(deepLink.getCode(), dto.getCode());
    }

    @Test
    public void getDeepLinksByProduct() {
        List<DeepLinkModel> deepLinks = Collections.singletonList(deepLink);
        when(deepLinkService.getDeepLinksByProduct(product)).thenReturn(deepLinks);

        List<DeepLinkSummaryData> result = deepLinkFacade.getDeepLinks();

        DeepLinkSummaryData dto = result.get(0);

        assertEquals(deepLinks.size(), result.size());
        assertEquals(deepLink.getUrl(), dto.getUrl());
        assertEquals(deepLink.getName(), dto.getName());
        assertEquals(deepLink.getCode(), dto.getCode());
    }
}