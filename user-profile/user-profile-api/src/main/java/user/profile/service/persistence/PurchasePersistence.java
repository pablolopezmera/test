/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package user.profile.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import user.profile.exception.NoSuchPurchaseException;

import user.profile.model.Purchase;

/**
 * The persistence interface for the purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see user.profile.service.persistence.impl.PurchasePersistenceImpl
 * @see PurchaseUtil
 * @generated
 */
@ProviderType
public interface PurchasePersistence extends BasePersistence<Purchase> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseUtil} to access the purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the purchases where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching purchases
	*/
	public java.util.List<Purchase> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the purchases where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @return the range of matching purchases
	*/
	public java.util.List<Purchase> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the purchases where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching purchases
	*/
	public java.util.List<Purchase> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator);

	/**
	* Returns an ordered range of all the purchases where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching purchases
	*/
	public java.util.List<Purchase> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public Purchase findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException;

	/**
	* Returns the first purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public Purchase fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator);

	/**
	* Returns the last purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public Purchase findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException;

	/**
	* Returns the last purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public Purchase fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator);

	/**
	* Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	*
	* @param purchasePK the primary key of the current purchase
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next purchase
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public Purchase[] findByUuid_PrevAndNext(
		user.profile.service.persistence.PurchasePK purchasePK,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException;

	/**
	* Removes all the purchases where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of purchases where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching purchases
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the purchase where screenname = &#63; or throws a {@link NoSuchPurchaseException} if it could not be found.
	*
	* @param screenname the screenname
	* @return the matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public Purchase findByscreenname(java.lang.String screenname)
		throws NoSuchPurchaseException;

	/**
	* Returns the purchase where screenname = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param screenname the screenname
	* @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public Purchase fetchByscreenname(java.lang.String screenname);

	/**
	* Returns the purchase where screenname = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param screenname the screenname
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public Purchase fetchByscreenname(java.lang.String screenname,
		boolean retrieveFromCache);

	/**
	* Removes the purchase where screenname = &#63; from the database.
	*
	* @param screenname the screenname
	* @return the purchase that was removed
	*/
	public Purchase removeByscreenname(java.lang.String screenname)
		throws NoSuchPurchaseException;

	/**
	* Returns the number of purchases where screenname = &#63;.
	*
	* @param screenname the screenname
	* @return the number of matching purchases
	*/
	public int countByscreenname(java.lang.String screenname);

	/**
	* Caches the purchase in the entity cache if it is enabled.
	*
	* @param purchase the purchase
	*/
	public void cacheResult(Purchase purchase);

	/**
	* Caches the purchases in the entity cache if it is enabled.
	*
	* @param purchases the purchases
	*/
	public void cacheResult(java.util.List<Purchase> purchases);

	/**
	* Creates a new purchase with the primary key. Does not add the purchase to the database.
	*
	* @param purchasePK the primary key for the new purchase
	* @return the new purchase
	*/
	public Purchase create(
		user.profile.service.persistence.PurchasePK purchasePK);

	/**
	* Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase that was removed
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public Purchase remove(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws NoSuchPurchaseException;

	public Purchase updateImpl(Purchase purchase);

	/**
	* Returns the purchase with the primary key or throws a {@link NoSuchPurchaseException} if it could not be found.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public Purchase findByPrimaryKey(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws NoSuchPurchaseException;

	/**
	* Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	*/
	public Purchase fetchByPrimaryKey(
		user.profile.service.persistence.PurchasePK purchasePK);

	@Override
	public java.util.Map<java.io.Serializable, Purchase> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the purchases.
	*
	* @return the purchases
	*/
	public java.util.List<Purchase> findAll();

	/**
	* Returns a range of all the purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @return the range of purchases
	*/
	public java.util.List<Purchase> findAll(int start, int end);

	/**
	* Returns an ordered range of all the purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of purchases
	*/
	public java.util.List<Purchase> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator);

	/**
	* Returns an ordered range of all the purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of purchases
	*/
	public java.util.List<Purchase> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Purchase> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the purchases from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of purchases.
	*
	* @return the number of purchases
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}