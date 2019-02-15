/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 1, 2018 1:09:09 PM                      ---
 * ----------------------------------------------------------------
 */
package com.training.deeplink.jalo;

import com.training.deeplink.constants.DeeplinkConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem DeepLink}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedDeepLink extends GenericItem
{
	/** Qualifier of the <code>DeepLink.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>DeepLink.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>DeepLink.status</code> attribute **/
	public static final String STATUS = "status";
	/** Qualifier of the <code>DeepLink.url</code> attribute **/
	public static final String URL = "url";
	/** Qualifier of the <code>DeepLink.successVerificationDate</code> attribute **/
	public static final String SUCCESSVERIFICATIONDATE = "successVerificationDate";
	/** Qualifier of the <code>DeepLink.dateAdded</code> attribute **/
	public static final String DATEADDED = "dateAdded";
	/** Qualifier of the <code>DeepLink.failVerificationDate</code> attribute **/
	public static final String FAILVERIFICATIONDATE = "failVerificationDate";
	/** Qualifier of the <code>DeepLink.user</code> attribute **/
	public static final String USER = "user";
	/** Qualifier of the <code>DeepLink.products</code> attribute **/
	public static final String PRODUCTS = "products";
	/** Relation ordering override parameter constants for Product2DeepLink from ((deeplink))*/
	protected static String PRODUCT2DEEPLINK_SRC_ORDERED = "relation.Product2DeepLink.source.ordered";
	protected static String PRODUCT2DEEPLINK_TGT_ORDERED = "relation.Product2DeepLink.target.ordered";
	/** Relation disable markmodifed parameter constants for Product2DeepLink from ((deeplink))*/
	protected static String PRODUCT2DEEPLINK_MARKMODIFIED = "relation.Product2DeepLink.markmodified";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n USER's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedDeepLink> USERHANDLER = new BidirectionalOneToManyHandler<GeneratedDeepLink>(
	DeeplinkConstants.TC.DEEPLINK,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(STATUS, AttributeMode.INITIAL);
		tmp.put(URL, AttributeMode.INITIAL);
		tmp.put(SUCCESSVERIFICATIONDATE, AttributeMode.INITIAL);
		tmp.put(DATEADDED, AttributeMode.INITIAL);
		tmp.put(FAILVERIFICATIONDATE, AttributeMode.INITIAL);
		tmp.put(USER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.code</code> attribute.
	 * @return the code - unique code of the link
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.code</code> attribute.
	 * @return the code - unique code of the link
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.code</code> attribute. 
	 * @param value the code - unique code of the link
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.code</code> attribute. 
	 * @param value the code - unique code of the link
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		USERHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.dateAdded</code> attribute.
	 * @return the dateAdded - date of the link addition
	 */
	public Date getDateAdded(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, DATEADDED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.dateAdded</code> attribute.
	 * @return the dateAdded - date of the link addition
	 */
	public Date getDateAdded()
	{
		return getDateAdded( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.dateAdded</code> attribute. 
	 * @param value the dateAdded - date of the link addition
	 */
	public void setDateAdded(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, DATEADDED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.dateAdded</code> attribute. 
	 * @param value the dateAdded - date of the link addition
	 */
	public void setDateAdded(final Date value)
	{
		setDateAdded( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.failVerificationDate</code> attribute.
	 * @return the failVerificationDate - date of the last fail verification
	 */
	public Date getFailVerificationDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, FAILVERIFICATIONDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.failVerificationDate</code> attribute.
	 * @return the failVerificationDate - date of the last fail verification
	 */
	public Date getFailVerificationDate()
	{
		return getFailVerificationDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.failVerificationDate</code> attribute. 
	 * @param value the failVerificationDate - date of the last fail verification
	 */
	public void setFailVerificationDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, FAILVERIFICATIONDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.failVerificationDate</code> attribute. 
	 * @param value the failVerificationDate - date of the last fail verification
	 */
	public void setFailVerificationDate(final Date value)
	{
		setFailVerificationDate( getSession().getSessionContext(), value );
	}
	
	@Override
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Product");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.name</code> attribute.
	 * @return the name - name of the link
	 */
	public String getName(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedDeepLink.getName requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.name</code> attribute.
	 * @return the name - name of the link
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.name</code> attribute. 
	 * @return the localized name - name of the link
	 */
	public Map<Language,String> getAllName(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,NAME,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.name</code> attribute. 
	 * @return the localized name - name of the link
	 */
	public Map<Language,String> getAllName()
	{
		return getAllName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.name</code> attribute. 
	 * @param value the name - name of the link
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedDeepLink.setName requires a session language", 0 );
		}
		setLocalizedProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.name</code> attribute. 
	 * @param value the name - name of the link
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.name</code> attribute. 
	 * @param value the name - name of the link
	 */
	public void setAllName(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.name</code> attribute. 
	 * @param value the name - name of the link
	 */
	public void setAllName(final Map<Language,String> value)
	{
		setAllName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.products</code> attribute.
	 * @return the products
	 */
	public Set<Product> getProducts(final SessionContext ctx)
	{
		final List<Product> items = getLinkedItems( 
			ctx,
			false,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			"Product",
			null,
			false,
			false
		);
		return new LinkedHashSet<Product>(items);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.products</code> attribute.
	 * @return the products
	 */
	public Set<Product> getProducts()
	{
		return getProducts( getSession().getSessionContext() );
	}
	
	public long getProductsCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			"Product",
			null
		);
	}
	
	public long getProductsCount()
	{
		return getProductsCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.products</code> attribute. 
	 * @param value the products
	 */
	public void setProducts(final SessionContext ctx, final Set<Product> value)
	{
		setLinkedItems( 
			ctx,
			false,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.products</code> attribute. 
	 * @param value the products
	 */
	public void setProducts(final Set<Product> value)
	{
		setProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to products. 
	 * @param value the item to add to products
	 */
	public void addToProducts(final SessionContext ctx, final Product value)
	{
		addLinkedItems( 
			ctx,
			false,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to products. 
	 * @param value the item to add to products
	 */
	public void addToProducts(final Product value)
	{
		addToProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from products. 
	 * @param value the item to remove from products
	 */
	public void removeFromProducts(final SessionContext ctx, final Product value)
	{
		removeLinkedItems( 
			ctx,
			false,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from products. 
	 * @param value the item to remove from products
	 */
	public void removeFromProducts(final Product value)
	{
		removeFromProducts( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.status</code> attribute.
	 * @return the status - status of the link
	 */
	public EnumerationValue getStatus(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.status</code> attribute.
	 * @return the status - status of the link
	 */
	public EnumerationValue getStatus()
	{
		return getStatus( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.status</code> attribute. 
	 * @param value the status - status of the link
	 */
	public void setStatus(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, STATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.status</code> attribute. 
	 * @param value the status - status of the link
	 */
	public void setStatus(final EnumerationValue value)
	{
		setStatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.successVerificationDate</code> attribute.
	 * @return the successVerificationDate - date of the last success verification
	 */
	public Date getSuccessVerificationDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, SUCCESSVERIFICATIONDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.successVerificationDate</code> attribute.
	 * @return the successVerificationDate - date of the last success verification
	 */
	public Date getSuccessVerificationDate()
	{
		return getSuccessVerificationDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.successVerificationDate</code> attribute. 
	 * @param value the successVerificationDate - date of the last success verification
	 */
	public void setSuccessVerificationDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, SUCCESSVERIFICATIONDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.successVerificationDate</code> attribute. 
	 * @param value the successVerificationDate - date of the last success verification
	 */
	public void setSuccessVerificationDate(final Date value)
	{
		setSuccessVerificationDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.url</code> attribute.
	 * @return the url - url of the string
	 */
	public String getUrl(final SessionContext ctx)
	{
		return (String)getProperty( ctx, URL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.url</code> attribute.
	 * @return the url - url of the string
	 */
	public String getUrl()
	{
		return getUrl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.url</code> attribute. 
	 * @param value the url - url of the string
	 */
	public void setUrl(final SessionContext ctx, final String value)
	{
		setProperty(ctx, URL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.url</code> attribute. 
	 * @param value the url - url of the string
	 */
	public void setUrl(final String value)
	{
		setUrl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.user</code> attribute.
	 * @return the user
	 */
	public User getUser(final SessionContext ctx)
	{
		return (User)getProperty( ctx, USER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>DeepLink.user</code> attribute.
	 * @return the user
	 */
	public User getUser()
	{
		return getUser( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final SessionContext ctx, final User value)
	{
		USERHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>DeepLink.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final User value)
	{
		setUser( getSession().getSessionContext(), value );
	}
	
}
