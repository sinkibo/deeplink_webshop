package com.training.deeplink.events;

import com.training.deeplink.jobs.LinkVerificationJob;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.servicelayer.event.events.AfterItemCreationEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

public class NewDeepLinkListener extends AbstractEventListener<AfterItemCreationEvent> {

    private LinkVerificationJob linkVerificator;
    private ModelService modelService;

    public void setLinkVerificator(LinkVerificationJob linkVerificator) {
        this.linkVerificator = linkVerificator;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    protected void onEvent(AfterItemCreationEvent afterItemCreationEvent) {
        if (afterItemCreationEvent != null && afterItemCreationEvent.getSource() != null) {
            final Object object = modelService.get(afterItemCreationEvent.getSource());
            if (object instanceof DeepLinkModel) {
                linkVerificator.perform(null);
            }
        }
    }
}
