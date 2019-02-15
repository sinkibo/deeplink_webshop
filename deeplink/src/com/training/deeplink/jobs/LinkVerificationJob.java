package com.training.deeplink.jobs;

import com.training.deeplink.enums.Status;
import com.training.deeplink.model.DeepLinkModel;
import com.training.deeplink.service.DeepLinkService;
import com.training.deeplink.service.DeepLinkVerificationService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;

import java.util.List;

public class LinkVerificationJob extends AbstractJobPerformable<CronJobModel> {

    private static final Logger LOG = Logger.getLogger(LinkVerificationJob.class);

    private DeepLinkService deepLinkService;

    private DeepLinkVerificationService verificator;
    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        LOG.info("started link verification");
        List<DeepLinkModel> newDeepLinks = deepLinkService.getDeepLinksByStatus(Status.NEW);
        LOG.info("found " + newDeepLinks.size() + " links with status " + Status.NEW);
        newDeepLinks.forEach((d -> {
            verificator.verifyDeepLink(d);
            deepLinkService.saveDeepLink(d);
        }));
        LOG.info("finished link verification");
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    public void setDeepLinkService(DeepLinkService deepLinkService) {
        this.deepLinkService = deepLinkService;
    }

    public void setVerificator(DeepLinkVerificationService verificator) {
        this.verificator = verificator;
    }
}
