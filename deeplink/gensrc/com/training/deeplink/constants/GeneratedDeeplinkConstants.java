/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 1, 2018 1:09:09 PM                      ---
 * ----------------------------------------------------------------
 */
package com.training.deeplink.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast","PMD"})
public class GeneratedDeeplinkConstants
{
	public static final String EXTENSIONNAME = "deeplink";
	public static class TC
	{
		public static final String DEEPLINK = "DeepLink".intern();
		public static final String ROLE = "Role".intern();
		public static final String STATUS = "Status".intern();
	}
	public static class Attributes
	{
		public static class Product
		{
			public static final String DEEPLINKCOUNT = "deepLinkCount".intern();
			public static final String DEEPLINKS = "deepLinks".intern();
		}
		public static class User
		{
			public static final String DEEPLINKS = "deepLinks".intern();
		}
	}
	public static class Enumerations
	{
		public static class Role
		{
			public static final String CUSTOMER = "CUSTOMER".intern();
			public static final String MODERATOR = "MODERATOR".intern();
			public static final String ADMIN = "ADMIN".intern();
		}
		public static class Status
		{
			public static final String NEW = "NEW".intern();
			public static final String VERIFIED = "VERIFIED".intern();
			public static final String NOT_AVAILABLE = "NOT_AVAILABLE".intern();
		}
	}
	public static class Relations
	{
		public static final String PRODUCT2DEEPLINK = "Product2DeepLink".intern();
		public static final String USER2DEEPLINK = "User2DeepLink".intern();
	}
	
	protected GeneratedDeeplinkConstants()
	{
		// private constructor
	}
	
	
}
