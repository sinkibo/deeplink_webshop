package com.training.deeplink.provider;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.springframework.beans.factory.annotation.Required;
import reactor.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDeepLinkURLProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {
    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object o) throws FieldValueProviderException {
        if (o instanceof ProductModel) {
            final ProductModel productModel = (ProductModel) o;

            return new ArrayList<>(createFieldValues(productModel, indexedProperty));
        }

        throw new FieldValueProviderException("Error: item is not a ProductModel type !");
    }

    protected List<FieldValue> createFieldValues(final ProductModel product, final IndexedProperty indexedProperty) {
        final List<FieldValue> fieldValues = new ArrayList<>();
        product.getDeepLinks().forEach(o -> {
            String name = o.getUrl();
            if (StringUtils.hasText(name)) {
                addFieldValues(fieldValues, indexedProperty, name);
            }
        });
        return fieldValues;
    }

    protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty, final Object value) {
        final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, value));
        }
    }

    @Required
    public void setFieldNameProvider(final FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }

}
