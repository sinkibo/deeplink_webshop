package com.training.deeplink.service.impl;

import com.training.deeplink.enums.Status;
import com.training.deeplink.model.DeepLinkModel;
import com.training.deeplink.service.DeepLinkVerificationService;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultDeepLinkVerificationService implements DeepLinkVerificationService {

    private static final Logger LOG = Logger.getLogger(DefaultDeepLinkVerificationService.class);

    @Override
    public boolean verifyDeepLink(DeepLinkModel deepLinkModel) {
        String url = deepLinkModel.getUrl();

        LOG.info("started link verification: " + url);

        boolean isUrlValid = url != null && StringUtils.hasText(url) && isLinkAvailable(url);

        deepLinkModel.setStatus(isUrlValid ? Status.VERIFIED : Status.NOT_AVAILABLE);

        LOG.info("finished link verification, status is " + deepLinkModel.getStatus());

        return isUrlValid;
    }

    private boolean isLinkAvailable(String link) {
        if (!isLinkValid(link)) {
            return false;
        }

        boolean result = false;
        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int response = http.getResponseCode();

            LOG.info(link + " response is: " + response);

            result = isResponseCodeValid(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOG.info(link + " available: " + result);
        return result;
    }

    private boolean isLinkValid(String link) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(link);
    }

    private boolean isResponseCodeValid(int responseCode) {
        return responseCode == 200;
    }
}
