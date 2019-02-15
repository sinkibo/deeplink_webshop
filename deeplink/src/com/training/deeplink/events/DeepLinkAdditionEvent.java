package com.training.deeplink.events;

import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public class DeepLinkAdditionEvent extends AbstractEvent {

    private DeepLinkModel deepLink;

    public DeepLinkAdditionEvent(DeepLinkModel deepLink) {
        this.deepLink = deepLink;
    }

    public DeepLinkModel getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(DeepLinkModel deepLink) {
        this.deepLink = deepLink;
    }
}
