/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 1, 2018 1:09:09 PM                      ---
 * ----------------------------------------------------------------
 */
package com.training.deeplink.jalo;

import com.training.deeplink.constants.DeeplinkConstants;
import com.training.deeplink.jalo.DeepLink;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.OneToManyHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type <code>DeeplinkManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedDeeplinkManager extends Extension
{
	/** Relation ordering override parameter constants for Product2DeepLink from ((deeplink))*/
	protected static String PRODUCT2DEEPLINK_SRC_ORDERED = "relation.Product2DeepLink.source.ordered";
	protected static String PRODUCT2DEEPLINK_TGT_ORDERED = "relation.Product2DeepLink.target.ordered";
	/** Relation disable markmodifed parameter constants for Product2DeepLink from ((deeplink))*/
	protected static String PRODUCT2DEEPLINK_MARKMODIFIED = "relation.Product2DeepLink.markmodified";
	/**
	* {@link OneToManyHandler} for handling 1:n DEEPLINKS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<DeepLink> USER2DEEPLINKDEEPLINKSHANDLER = new OneToManyHandler<DeepLink>(
	DeeplinkConstants.TC.DEEPLINK,
	false,
	"user",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public DeepLink createDeepLink(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( DeeplinkConstants.TC.DEEPLINK );
			return (DeepLink)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating DeepLink : "+e.getMessage(), 0 );
		}
	}
	
	public DeepLink createDeepLink(final Map attributeValues)
	{
		return createDeepLink( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deepLinks</code> attribute.
	 * @return the deepLinks
	 */
	public Collection<DeepLink> getDeepLinks(final SessionContext ctx, final Product item)
	{
		final List<DeepLink> items = item.getLinkedItems( 
			ctx,
			true,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			"DeepLink",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.deepLinks</code> attribute.
	 * @return the deepLinks
	 */
	public Collection<DeepLink> getDeepLinks(final Product item)
	{
		return getDeepLinks( getSession().getSessionContext(), item );
	}
	
	public long getDeepLinksCount(final SessionContext ctx, final Product item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			"DeepLink",
			null
		);
	}
	
	public long getDeepLinksCount(final Product item)
	{
		return getDeepLinksCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deepLinks</code> attribute. 
	 * @param value the deepLinks
	 */
	public void setDeepLinks(final SessionContext ctx, final Product item, final Collection<DeepLink> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.deepLinks</code> attribute. 
	 * @param value the deepLinks
	 */
	public void setDeepLinks(final Product item, final Collection<DeepLink> value)
	{
		setDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deepLinks. 
	 * @param value the item to add to deepLinks
	 */
	public void addToDeepLinks(final SessionContext ctx, final Product item, final DeepLink value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deepLinks. 
	 * @param value the item to add to deepLinks
	 */
	public void addToDeepLinks(final Product item, final DeepLink value)
	{
		addToDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deepLinks. 
	 * @param value the item to remove from deepLinks
	 */
	public void removeFromDeepLinks(final SessionContext ctx, final Product item, final DeepLink value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			DeeplinkConstants.Relations.PRODUCT2DEEPLINK,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PRODUCT2DEEPLINK_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deepLinks. 
	 * @param value the item to remove from deepLinks
	 */
	public void removeFromDeepLinks(final Product item, final DeepLink value)
	{
		removeFromDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.deepLinks</code> attribute.
	 * @return the deepLinks
	 */
	public Set<DeepLink> getDeepLinks(final SessionContext ctx, final User item)
	{
		return (Set<DeepLink>)USER2DEEPLINKDEEPLINKSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.deepLinks</code> attribute.
	 * @return the deepLinks
	 */
	public Set<DeepLink> getDeepLinks(final User item)
	{
		return getDeepLinks( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.deepLinks</code> attribute. 
	 * @param value the deepLinks
	 */
	public void setDeepLinks(final SessionContext ctx, final User item, final Set<DeepLink> value)
	{
		USER2DEEPLINKDEEPLINKSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.deepLinks</code> attribute. 
	 * @param value the deepLinks
	 */
	public void setDeepLinks(final User item, final Set<DeepLink> value)
	{
		setDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deepLinks. 
	 * @param value the item to add to deepLinks
	 */
	public void addToDeepLinks(final SessionContext ctx, final User item, final DeepLink value)
	{
		USER2DEEPLINKDEEPLINKSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to deepLinks. 
	 * @param value the item to add to deepLinks
	 */
	public void addToDeepLinks(final User item, final DeepLink value)
	{
		addToDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deepLinks. 
	 * @param value the item to remove from deepLinks
	 */
	public void removeFromDeepLinks(final SessionContext ctx, final User item, final DeepLink value)
	{
		USER2DEEPLINKDEEPLINKSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from deepLinks. 
	 * @param value the item to remove from deepLinks
	 */
	public void removeFromDeepLinks(final User item, final DeepLink value)
	{
		removeFromDeepLinks( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return DeeplinkConstants.EXTENSIONNAME;
	}
	
}
