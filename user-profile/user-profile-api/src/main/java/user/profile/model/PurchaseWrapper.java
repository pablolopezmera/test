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

package user.profile.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
@ProviderType
public class PurchaseWrapper implements Purchase, ModelWrapper<Purchase> {
	public PurchaseWrapper(Purchase purchase) {
		_purchase = purchase;
	}

	@Override
	public Class<?> getModelClass() {
		return Purchase.class;
	}

	@Override
	public String getModelClassName() {
		return Purchase.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("screenname", getScreenname());
		attributes.put("hash", getHash());
		attributes.put("date_time", getDate_time());
		attributes.put("curr_from", getCurr_from());
		attributes.put("value_from", getValue_from());
		attributes.put("curr_to", getCurr_to());
		attributes.put("value_to", getValue_to());
		attributes.put("status", getStatus());
		attributes.put("ewallet", getEwallet());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String screenname = (String)attributes.get("screenname");

		if (screenname != null) {
			setScreenname(screenname);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}

		Date date_time = (Date)attributes.get("date_time");

		if (date_time != null) {
			setDate_time(date_time);
		}

		String curr_from = (String)attributes.get("curr_from");

		if (curr_from != null) {
			setCurr_from(curr_from);
		}

		String value_from = (String)attributes.get("value_from");

		if (value_from != null) {
			setValue_from(value_from);
		}

		String curr_to = (String)attributes.get("curr_to");

		if (curr_to != null) {
			setCurr_to(curr_to);
		}

		String value_to = (String)attributes.get("value_to");

		if (value_to != null) {
			setValue_to(value_to);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String ewallet = (String)attributes.get("ewallet");

		if (ewallet != null) {
			setEwallet(ewallet);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _purchase.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _purchase.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _purchase.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _purchase.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<user.profile.model.Purchase> toCacheModel() {
		return _purchase.toCacheModel();
	}

	@Override
	public int compareTo(user.profile.model.Purchase purchase) {
		return _purchase.compareTo(purchase);
	}

	@Override
	public int hashCode() {
		return _purchase.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _purchase.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PurchaseWrapper((Purchase)_purchase.clone());
	}

	/**
	* Returns the curr_from of this purchase.
	*
	* @return the curr_from of this purchase
	*/
	@Override
	public java.lang.String getCurr_from() {
		return _purchase.getCurr_from();
	}

	/**
	* Returns the curr_to of this purchase.
	*
	* @return the curr_to of this purchase
	*/
	@Override
	public java.lang.String getCurr_to() {
		return _purchase.getCurr_to();
	}

	/**
	* Returns the ewallet of this purchase.
	*
	* @return the ewallet of this purchase
	*/
	@Override
	public java.lang.String getEwallet() {
		return _purchase.getEwallet();
	}

	/**
	* Returns the hash of this purchase.
	*
	* @return the hash of this purchase
	*/
	@Override
	public java.lang.String getHash() {
		return _purchase.getHash();
	}

	/**
	* Returns the screenname of this purchase.
	*
	* @return the screenname of this purchase
	*/
	@Override
	public java.lang.String getScreenname() {
		return _purchase.getScreenname();
	}

	/**
	* Returns the status of this purchase.
	*
	* @return the status of this purchase
	*/
	@Override
	public java.lang.String getStatus() {
		return _purchase.getStatus();
	}

	/**
	* Returns the uuid of this purchase.
	*
	* @return the uuid of this purchase
	*/
	@Override
	public java.lang.String getUuid() {
		return _purchase.getUuid();
	}

	/**
	* Returns the value_from of this purchase.
	*
	* @return the value_from of this purchase
	*/
	@Override
	public java.lang.String getValue_from() {
		return _purchase.getValue_from();
	}

	/**
	* Returns the value_to of this purchase.
	*
	* @return the value_to of this purchase
	*/
	@Override
	public java.lang.String getValue_to() {
		return _purchase.getValue_to();
	}

	@Override
	public java.lang.String toString() {
		return _purchase.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _purchase.toXmlString();
	}

	/**
	* Returns the date_time of this purchase.
	*
	* @return the date_time of this purchase
	*/
	@Override
	public Date getDate_time() {
		return _purchase.getDate_time();
	}

	@Override
	public user.profile.model.Purchase toEscapedModel() {
		return new PurchaseWrapper(_purchase.toEscapedModel());
	}

	@Override
	public user.profile.model.Purchase toUnescapedModel() {
		return new PurchaseWrapper(_purchase.toUnescapedModel());
	}

	/**
	* Returns the primary key of this purchase.
	*
	* @return the primary key of this purchase
	*/
	@Override
	public user.profile.service.persistence.PurchasePK getPrimaryKey() {
		return _purchase.getPrimaryKey();
	}

	@Override
	public void persist() {
		_purchase.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_purchase.setCachedModel(cachedModel);
	}

	/**
	* Sets the curr_from of this purchase.
	*
	* @param curr_from the curr_from of this purchase
	*/
	@Override
	public void setCurr_from(java.lang.String curr_from) {
		_purchase.setCurr_from(curr_from);
	}

	/**
	* Sets the curr_to of this purchase.
	*
	* @param curr_to the curr_to of this purchase
	*/
	@Override
	public void setCurr_to(java.lang.String curr_to) {
		_purchase.setCurr_to(curr_to);
	}

	/**
	* Sets the date_time of this purchase.
	*
	* @param date_time the date_time of this purchase
	*/
	@Override
	public void setDate_time(Date date_time) {
		_purchase.setDate_time(date_time);
	}

	/**
	* Sets the ewallet of this purchase.
	*
	* @param ewallet the ewallet of this purchase
	*/
	@Override
	public void setEwallet(java.lang.String ewallet) {
		_purchase.setEwallet(ewallet);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_purchase.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_purchase.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_purchase.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hash of this purchase.
	*
	* @param hash the hash of this purchase
	*/
	@Override
	public void setHash(java.lang.String hash) {
		_purchase.setHash(hash);
	}

	@Override
	public void setNew(boolean n) {
		_purchase.setNew(n);
	}

	/**
	* Sets the primary key of this purchase.
	*
	* @param primaryKey the primary key of this purchase
	*/
	@Override
	public void setPrimaryKey(
		user.profile.service.persistence.PurchasePK primaryKey) {
		_purchase.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_purchase.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the screenname of this purchase.
	*
	* @param screenname the screenname of this purchase
	*/
	@Override
	public void setScreenname(java.lang.String screenname) {
		_purchase.setScreenname(screenname);
	}

	/**
	* Sets the status of this purchase.
	*
	* @param status the status of this purchase
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_purchase.setStatus(status);
	}

	/**
	* Sets the uuid of this purchase.
	*
	* @param uuid the uuid of this purchase
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_purchase.setUuid(uuid);
	}

	/**
	* Sets the value_from of this purchase.
	*
	* @param value_from the value_from of this purchase
	*/
	@Override
	public void setValue_from(java.lang.String value_from) {
		_purchase.setValue_from(value_from);
	}

	/**
	* Sets the value_to of this purchase.
	*
	* @param value_to the value_to of this purchase
	*/
	@Override
	public void setValue_to(java.lang.String value_to) {
		_purchase.setValue_to(value_to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PurchaseWrapper)) {
			return false;
		}

		PurchaseWrapper purchaseWrapper = (PurchaseWrapper)obj;

		if (Objects.equals(_purchase, purchaseWrapper._purchase)) {
			return true;
		}

		return false;
	}

	@Override
	public Purchase getWrappedModel() {
		return _purchase;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _purchase.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _purchase.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_purchase.resetOriginalValues();
	}

	private final Purchase _purchase;
}