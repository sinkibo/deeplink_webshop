package com.training.deeplink.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

@SystemSetup(extension = "deeplink")
public class DeeplinkCustomSetup {
    private static final Logger LOG = LoggerFactory.getLogger(DeeplinkCustomSetup.class);
    private ImportService importService;

    public ImportService getImportService() {
        return importService;
    }

    public void setImportService(final ImportService importService) {
        this.importService = importService;
    }

    @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
    public boolean putInMyEssentialData() {
        LOG.info("Starting custom essential data loading for the deeplink extension");
        LOG.info("Custom essential data loading for the deeplink extension completed.");
        return true;
    }

    @SystemSetup(type = SystemSetup.Type.PROJECT)
    public boolean addMyProjectData() {
        LOG.info("Starting custom project data loading for the deeplink extension");
        impexImport("/impex/deeplink-deeplinks.impex");
        impexImport("/impex/deeplink-deeplinks-en.impex");
        LOG.info("Custom project data loading for the deeplink extension completed.");
        return true;
    }

    protected boolean impexImport(final String filename) {
        final String message = "deeplink impexing [" + filename + "]...";
        try {
            LOG.info(message);
            final InputStream resourceAsStream = getClass().getResourceAsStream(filename);
            final ImportConfig importConfig = new ImportConfig();
            importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
            importConfig.setLegacyMode(Boolean.FALSE);
            final ImportResult importResult = getImportService().importData(importConfig);
            if (importResult.isError()) {
                LOG.error(message + " FAILED");
                return false;
            }
        } catch (final Exception e) {
            LOG.error(message + " FAILED", e);
            return false;
        }
        return true;
    }
}
