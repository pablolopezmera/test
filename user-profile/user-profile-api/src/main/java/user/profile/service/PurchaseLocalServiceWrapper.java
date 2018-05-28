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

package user.profile.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PurchaseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseLocalService
 * @generated
 */
@ProviderType
public class PurchaseLocalServiceWrapper implements PurchaseLocalService,
	ServiceWrapper<PurchaseLocalService> {
	public PurchaseLocalServiceWrapper(
		PurchaseLocalService purchaseLocalService) {
		_purchaseLocalService = purchaseLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _purchaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _purchaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of purchases.
	*
	* @return the number of purchases
	*/
	@Override
	public int getPurchasesCount() {
		return _purchaseLocalService.getPurchasesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _purchaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _purchaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link user.profile.model.impl.PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _purchaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link user.profile.model.impl.PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _purchaseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<user.profile.model.Purchase> findByscreenname(
		java.lang.String screenname) {
		return _purchaseLocalService.findByscreenname(screenname);
	}

	/**
	* Returns a range of all the purchases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link user.profile.model.impl.PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchases
	* @param end the upper bound of the range of purchases (not inclusive)
	* @return the range of purchases
	*/
	@Override
	public java.util.List<user.profile.model.Purchase> getPurchases(int start,
		int end) {
		return _purchaseLocalService.getPurchases(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _purchaseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _purchaseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the purchase to the database. Also notifies the appropriate model listeners.
	*
	* @param purchase the purchase
	* @return the purchase that was added
	*/
	@Override
	public user.profile.model.Purchase addPurchase(
		user.profile.model.Purchase purchase) {
		return _purchaseLocalService.addPurchase(purchase);
	}

	/**
	* Creates a new purchase with the primary key. Does not add the purchase to the database.
	*
	* @param purchasePK the primary key for the new purchase
	* @return the new purchase
	*/
	@Override
	public user.profile.model.Purchase createPurchase(
		user.profile.service.persistence.PurchasePK purchasePK) {
		return _purchaseLocalService.createPurchase(purchasePK);
	}

	/**
	* Deletes the purchase from the database. Also notifies the appropriate model listeners.
	*
	* @param purchase the purchase
	* @return the purchase that was removed
	*/
	@Override
	public user.profile.model.Purchase deletePurchase(
		user.profile.model.Purchase purchase) {
		return _purchaseLocalService.deletePurchase(purchase);
	}

	/**
	* Deletes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase that was removed
	* @throws PortalException if a purchase with the primary key could not be found
	*/
	@Override
	public user.profile.model.Purchase deletePurchase(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _purchaseLocalService.deletePurchase(purchasePK);
	}

	@Override
	public user.profile.model.Purchase fetchPurchase(
		user.profile.service.persistence.PurchasePK purchasePK) {
		return _purchaseLocalService.fetchPurchase(purchasePK);
	}

	/**
	* Returns the purchase with the primary key.
	*
	* @param purchasePK the primary key of the purchase
	* @return the purchase
	* @throws PortalException if a purchase with the primary key could not be found
	*/
	@Override
	public user.profile.model.Purchase getPurchase(
		user.profile.service.persistence.PurchasePK purchasePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _purchaseLocalService.getPurchase(purchasePK);
	}

	/**
	* Updates the purchase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchase the purchase
	* @return the purchase that was updated
	*/
	@Override
	public user.profile.model.Purchase updatePurchase(
		user.profile.model.Purchase purchase) {
		return _purchaseLocalService.updatePurchase(purchase);
	}

	@Override
	public PurchaseLocalService getWrappedService() {
		return _purchaseLocalService;
	}

	@Override
	public void setWrappedService(PurchaseLocalService purchaseLocalService) {
		_purchaseLocalService = purchaseLocalService;
	}

	private PurchaseLocalService _purchaseLocalService;
}