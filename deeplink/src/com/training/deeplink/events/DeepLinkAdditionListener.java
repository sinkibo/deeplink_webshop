package com.training.deeplink.events;

import com.training.deeplink.model.DeepLinkModel;
import com.training.deeplink.service.DeepLinkVerificationService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;

public class DeepLinkAdditionListener extends AbstractEventListener<DeepLinkAdditionEvent> {

    private DeepLinkVerificationService deepLinkVerificationService;

    @Override
    protected void onEvent(DeepLinkAdditionEvent deepLinkAdditionEvent) {
        DeepLinkModel deepLink = deepLinkAdditionEvent.getDeepLink();

        if (deepLink != null) {
            deepLinkVerificationService.verifyDeepLink(deepLink);
        }
    }

    public void setDeepLinkVerificationService(DeepLinkVerificationService deepLinkVerificationService) {
        this.deepLinkVerificationService = deepLinkVerificationService;
    }
}
