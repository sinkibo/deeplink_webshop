package com.training.deeplink.addon.jalo;

import com.training.deeplink.addon.constants.DeeplinkaddonConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class DeeplinkaddonManager extends GeneratedDeeplinkaddonManager {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(DeeplinkaddonManager.class.getName());

    public static final DeeplinkaddonManager getInstance() {
        ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
        return (DeeplinkaddonManager) em.getExtension(DeeplinkaddonConstants.EXTENSIONNAME);
    }

}
