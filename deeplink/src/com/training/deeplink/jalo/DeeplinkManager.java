package com.training.deeplink.jalo;

import com.training.deeplink.constants.DeeplinkConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class DeeplinkManager extends GeneratedDeeplinkManager {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(DeeplinkManager.class.getName());

    public static final DeeplinkManager getInstance() {
        ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
        return (DeeplinkManager) em.getExtension(DeeplinkConstants.EXTENSIONNAME);
    }

}
