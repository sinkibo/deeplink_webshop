package com.training.deeplink.events;

import com.training.deeplink.enums.Status;
import com.training.deeplink.model.DeepLinkModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

public class DeepLinkAdditionInterceptor implements PrepareInterceptor<DeepLinkModel> {

    private EventService eventService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void onPrepare(DeepLinkModel deepLinkModel, InterceptorContext interceptorContext) throws InterceptorException {
        if (deepLinkModel != null && (deepLinkModel.getStatus() == Status.NEW)) {
            eventService.publishEvent(new DeepLinkAdditionEvent(deepLinkModel));
        }
    }
}
