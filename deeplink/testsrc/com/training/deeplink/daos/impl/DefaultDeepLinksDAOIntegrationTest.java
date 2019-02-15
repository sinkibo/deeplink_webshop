package com.training.deeplink.daos.impl;

import com.training.deeplink.model.DeepLinkModel;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@IntegrationTest
public class DefaultDeepLinksDAOIntegrationTest extends ServicelayerTransactionalTest {

    private static final String DEEPLINK_NAME = "LINK NAME";
    private static final String DEEPLINK_URL = "http://someurl.com";

    private static ProductModel product;
    private static DeepLinkModel deepLink;

    @Resource
    private DefaultDeepLinksDAO deepLinkDAO;

    @Resource
    private ModelService modelService;

    @Before
    public void setUp(){
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
        deepLink.setProducts(Collections.singleton(product));
    }

    @Test
    public void deepLinkDAOTest() {
        int size = deepLinkDAO.findDeepLinks().size();

        modelService.save(product);
        modelService.save(deepLink);

        List<DeepLinkModel> links = deepLinkDAO.findDeepLinks();

        Assert.assertEquals(size + 1, links.size());

        List<DeepLinkModel> linksByProduct = deepLinkDAO.findDeepLinksByProduct(product);

        DeepLinkModel fetchedDeeplink = linksByProduct.get(0);

        Assert.assertEquals(DEEPLINK_NAME, fetchedDeeplink.getName());
        Assert.assertEquals(DEEPLINK_URL, fetchedDeeplink.getUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindDeepLinks_NullParam() {
        deepLinkDAO.findDeepLinksByProduct(null);
    }
}