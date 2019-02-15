package com.training.deeplink.service.impl;

import com.training.deeplink.daos.DeepLinkDAO;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@UnitTest
public class DefaultDeepLinkServiceUnitTest {

    @InjectMocks
    private DefaultDeepLinkService deepLinkService = new DefaultDeepLinkService();

    @Mock
    private DeepLinkDAO deepLinkDAO;

    private DeepLinkModel deepLink;
    private ProductModel product;

    private static final String DEEPLINK_URL = "http://url.com";

    private static final String DEEPLINK_NAME = "mylinkname";

    @Before
    public void setUp() {
        CatalogVersionModel catalogVersionModel = new CatalogVersionModel();
        CatalogModel catalogModel = new CatalogModel();
        catalogModel.setId("electronicsProductCatalog");
        catalogVersionModel.setCatalog(catalogModel);
        catalogVersionModel.setVersion("Online");

        product = new ProductModel();
        product.setDeepLinks(Collections.singletonList(deepLink));
        product.setName("my product");
        product.setCatalogVersion(catalogVersionModel);
        product.setCode("12345");

        deepLink = new DeepLinkModel();
        deepLink.setUrl(DEEPLINK_URL);
        deepLink.setName(DEEPLINK_NAME);
    }

    @Test
    public void testFindDeepLinks() {
        List<DeepLinkModel> deepLinks = Collections.singletonList(deepLink);
        when(deepLinkDAO.findDeepLinks()).thenReturn(deepLinks);

        List<DeepLinkModel> result = deepLinkService.getDeepLinks();

        assertEquals(deepLinks.size(), result.size());
        assertEquals(deepLinks.get(0), result.get(0));
    }

    @Test
    public void testFindDeepLinksByProduct() {
        List<DeepLinkModel> deepLinks = Collections.singletonList(deepLink);
        when(deepLinkDAO.findDeepLinksByProduct(product)).thenReturn(deepLinks);

        List<DeepLinkModel> result = deepLinkService.getDeepLinksByProduct(product);

        assertEquals(deepLinks.size(), result.size());
        assertEquals(deepLinks.get(0), result.get(0));
    }
}