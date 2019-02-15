/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.training.deeplink.setup;

import static com.training.deeplink.constants.DeeplinkConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.training.deeplink.constants.DeeplinkConstants;
import com.training.deeplink.service.DeeplinkService;


@SystemSetup(extension = DeeplinkConstants.EXTENSIONNAME)
public class DeeplinkSystemSetup
{
	private final DeeplinkService deeplinkService;

	public DeeplinkSystemSetup(final DeeplinkService deeplinkService)
	{
		this.deeplinkService = deeplinkService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		deeplinkService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DeeplinkSystemSetup.class.getResourceAsStream("/deeplink/sap-hybris-platform.png");
	}
}
