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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import user.profile.model.Purchase;

import java.util.List;

/**
 * The persistence utility for the purchase service. This utility wraps {@link user.profile.service.persistence.impl.PurchasePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchasePersistence
 * @see user.profile.service.persistence.impl.PurchasePersistenceImpl
 * @generated
 */
@ProviderType
public class PurchaseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Purchase purchase) {
		getPersistence().clearCache(purchase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Purchase> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Purchase update(Purchase purchase) {
		return getPersistence().update(purchase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Purchase update(Purchase purchase,
		ServiceContext serviceContext) {
		return getPersistence().update(purchase, serviceContext);
	}

	/**
	* Returns all the purchases where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching purchases
	*/
	public static List<Purchase> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Purchase> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Purchase> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Purchase> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Purchase> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Purchase> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public static Purchase findByUuid_First(java.lang.String uuid,
		OrderByComparator<Purchase> orderByComparator)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public static Purchase fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Purchase> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public static Purchase findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Purchase> orderByComparator)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last purchase in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public static Purchase fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Purchase> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	*
	* @param purchasePK the primary key of the current purchase
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next purchase
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public static Purchase[] findByUuid_PrevAndNext(
		user.profile.service.persistence.PurchasePK purchasePK,
		java.lang.String uuid, OrderByComparator<Purchase> orderByComparator)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence()
				   .findByUuid_PrevAndNext(purchasePK, uuid, orderByComparator);
	}

	/**
	* Removes all the purchases where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of purchases where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching purchases
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the purchase where screenname = &#63; or throws a {@link NoSuchPurchaseException} if it could not be found.
	*
	* @param screenname the screenname
	* @return the matching purchase
	* @throws NoSuchPurchaseException if a matching purchase could not be found
	*/
	public static Purchase findByscreenname(java.lang.String screenname)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().findByscreenname(screenname);
	}

	/**
	* Returns the purchase where screenname = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param screenname the screenname
	* @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public static Purchase fetchByscreenname(java.lang.String screenname) {
		return getPersistence().fetchByscreenname(screenname);
	}

	/**
	* Returns the purchase where screenname = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param screenname the screenname
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching purchase, or <code>null</code> if a matching purchase could not be found
	*/
	public static Purchase fetchByscreenname(java.lang.String screenname,
		boolean retrieveFromCache) {
		return getPersistence().fetchByscreenname(screenname, retrieveFromCache);
	}

	/**
	* Removes the purchase where screenname = &#63; from the database.
	*
	* @param screenname the screenname
	* @return the purchase that was removed
	*/
	public static Purchase removeByscreenname(java.lang.String screenname)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().removeByscreenname(screenname);
	}

	/**
	* Returns the number of purchases where screenname = &#63;.
	*
	* @param screenname the screenname
	* @return the number of matching purchases
	*/
	public static int countByscreenname(java.lang.String screenname) {
		return getPersistence().countByscreenname(screenname);
	}

	/**
	* Caches the purchase in the entity cache if it is enabled.
	*
	* @param purchase the purchase
	*/
	public static void cacheResult(Purchase purchase) {
		getPersistence().cacheResult(purchase);
	}

	/**
	* Caches the purchases in the entity cache if it is enabled.
	*
	* @param purchases the purchases
	*/
	public static void cacheResult(List<Purchase> purchases) {
		getPersistence().cacheResult(purchases);
	}

	/**
	* Creates a new purchase with the primary key. Does not add the purchase to the database.
	*
	* @param purchasePK the primary key for the new purchase
	* @return the new purchase
	*/
	public static Purchase create(
		user.profile.service.persistence.PurchasePK purchasePK) {
		return getPersistence().create(purchasePK);
	}

	/**
	* Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase that was removed
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public static Purchase remove(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().remove(purchasePK);
	}

	public static Purchase updateImpl(Purchase purchase) {
		return getPersistence().updateImpl(purchase);
	}

	/**
	* Returns the purchase with the primary key or throws a {@link NoSuchPurchaseException} if it could not be found.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase
	* @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	*/
	public static Purchase findByPrimaryKey(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws user.profile.exception.NoSuchPurchaseException {
		return getPersistence().findByPrimaryKey(purchasePK);
	}

	/**
	* Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	*/
	public static Purchase fetchByPrimaryKey(
		user.profile.service.persistence.PurchasePK purchasePK) {
		return getPersistence().fetchByPrimaryKey(purchasePK);
	}

	public static java.util.Map<java.io.Serializable, Purchase> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the purchases.
	*
	* @return the purchases
	*/
	public static List<Purchase> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Purchase> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Purchase> findAll(int start, int end,
		OrderByComparator<Purchase> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Purchase> findAll(int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the purchases from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of purchases.
	*
	* @return the number of purchases
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PurchasePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PurchasePersistence, PurchasePersistence> _serviceTracker =
		ServiceTrackerFactory.open(PurchasePersistence.class);
}