package com.training.deeplink.provider;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
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
import java.util.Locale;

public class ProductDeepLinkNameProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {

    private FieldNameProvider fieldNameProvider;
    private CommonI18NService commonI18NService;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object o) throws FieldValueProviderException {
        if (o instanceof ProductModel) {
            final ProductModel productModel = (ProductModel) o;

            final Collection<FieldValue> fieldValues = new ArrayList<>();

            // case of the indexed property is localized
            if (indexedProperty.isLocalized()) {
                // retrieve and iterate over all the configured languages
                final Collection<LanguageModel> languages = indexConfig.getLanguages();
                for (final LanguageModel language : languages) {
                    fieldValues.addAll(createFieldValues(productModel, language, indexedProperty));
                }
            }
            // case of the indexed property is not localized
            else {
                fieldValues.addAll(createFieldValues(productModel, null, indexedProperty));
            }
            return fieldValues;
        }

        throw new FieldValueProviderException("Error: item is not a ProductModel type !");
    }

    protected List<FieldValue> createFieldValues(final ProductModel product, final LanguageModel language, final IndexedProperty indexedProperty) {
        Locale locale = commonI18NService.getLocaleForLanguage(language);
        final List<FieldValue> fieldValues = new ArrayList<>();
        product.getDeepLinks().forEach(o -> {
            String name = o.getName(locale);
            if (StringUtils.hasText(name)) {
                addFieldValues(fieldValues, indexedProperty, language, name);
            }
        });
        return fieldValues;
    }

    protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty, final LanguageModel language, final Object value) {
        final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, language == null ? null : language.getIsocode());
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, value));
        }
    }

    @Required
    public void setFieldNameProvider(final FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }

    @Required
    public void setCommonI18NService(final CommonI18NService commonI18NService) {
        this.commonI18NService = commonI18NService;
    }


}
