package com.training.deeplink.service;

import com.training.deeplink.model.DeepLinkModel;

public interface DeepLinkVerificationService {
    boolean verifyDeepLink(DeepLinkModel deepLinkModel);
}
