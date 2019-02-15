/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.training.deeplink.addon.controllers;


import com.training.deeplink.addon.model.DeepLinkCMSComponentModel;

/**
 */
public interface DeeplinkaddonControllerConstants
{
    interface Actions
    {
        interface Cms // NOSONAR
        {
            String _Prefix = "/view/"; // NOSONAR
            String _Suffix = "Controller"; // NOSONAR

            /**
             * Default CMS component controller
             */
            String DefaultCMSComponent = _Prefix + "DefaultCMSComponentController"; // NOSONAR

            /**
             * CMS components that have specific handlers
             */
            String DeepLinkCMSComponent = _Prefix + DeepLinkCMSComponentModel._TYPECODE + _Suffix; // NOSONAR
        }
    }

}
