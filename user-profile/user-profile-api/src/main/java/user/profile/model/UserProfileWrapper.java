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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
@ProviderType
public class UserProfileWrapper implements UserProfile,
	ModelWrapper<UserProfile> {
	public UserProfileWrapper(UserProfile userProfile) {
		_userProfile = userProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return UserProfile.class;
	}

	@Override
	public String getModelClassName() {
		return UserProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("anversoId", getAnversoId());
		attributes.put("reversoId", getReversoId());
		attributes.put("selfie", getSelfie());
		attributes.put("proofAddress", getProofAddress());
		attributes.put("idType", getIdType());
		attributes.put("idNumber", getIdNumber());
		attributes.put("country", getCountry());
		attributes.put("prov", getProv());
		attributes.put("city", getCity());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("homeNumber", getHomeNumber());
		attributes.put("postalCode", getPostalCode());
		attributes.put("approved", getApproved());
		attributes.put("phoneNumber", getPhoneNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String anversoId = (String)attributes.get("anversoId");

		if (anversoId != null) {
			setAnversoId(anversoId);
		}

		String reversoId = (String)attributes.get("reversoId");

		if (reversoId != null) {
			setReversoId(reversoId);
		}

		String selfie = (String)attributes.get("selfie");

		if (selfie != null) {
			setSelfie(selfie);
		}

		String proofAddress = (String)attributes.get("proofAddress");

		if (proofAddress != null) {
			setProofAddress(proofAddress);
		}

		String idType = (String)attributes.get("idType");

		if (idType != null) {
			setIdType(idType);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String prov = (String)attributes.get("prov");

		if (prov != null) {
			setProv(prov);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String homeNumber = (String)attributes.get("homeNumber");

		if (homeNumber != null) {
			setHomeNumber(homeNumber);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _userProfile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userProfile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userProfile.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userProfile.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<user.profile.model.UserProfile> toCacheModel() {
		return _userProfile.toCacheModel();
	}

	@Override
	public int compareTo(user.profile.model.UserProfile userProfile) {
		return _userProfile.compareTo(userProfile);
	}

	@Override
	public int hashCode() {
		return _userProfile.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userProfile.getPrimaryKeyObj();
	}

	/**
	* Returns the approved of this user profile.
	*
	* @return the approved of this user profile
	*/
	@Override
	public java.lang.Boolean getApproved() {
		return _userProfile.getApproved();
	}

	@Override
	public java.lang.Object clone() {
		return new UserProfileWrapper((UserProfile)_userProfile.clone());
	}

	/**
	* Returns the anverso ID of this user profile.
	*
	* @return the anverso ID of this user profile
	*/
	@Override
	public java.lang.String getAnversoId() {
		return _userProfile.getAnversoId();
	}

	/**
	* Returns the city of this user profile.
	*
	* @return the city of this user profile
	*/
	@Override
	public java.lang.String getCity() {
		return _userProfile.getCity();
	}

	/**
	* Returns the country of this user profile.
	*
	* @return the country of this user profile
	*/
	@Override
	public java.lang.String getCountry() {
		return _userProfile.getCountry();
	}

	/**
	* Returns the home number of this user profile.
	*
	* @return the home number of this user profile
	*/
	@Override
	public java.lang.String getHomeNumber() {
		return _userProfile.getHomeNumber();
	}

	/**
	* Returns the id number of this user profile.
	*
	* @return the id number of this user profile
	*/
	@Override
	public java.lang.String getIdNumber() {
		return _userProfile.getIdNumber();
	}

	/**
	* Returns the id type of this user profile.
	*
	* @return the id type of this user profile
	*/
	@Override
	public java.lang.String getIdType() {
		return _userProfile.getIdType();
	}

	/**
	* Returns the phone number of this user profile.
	*
	* @return the phone number of this user profile
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _userProfile.getPhoneNumber();
	}

	/**
	* Returns the postal code of this user profile.
	*
	* @return the postal code of this user profile
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _userProfile.getPostalCode();
	}

	/**
	* Returns the primary key of this user profile.
	*
	* @return the primary key of this user profile
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _userProfile.getPrimaryKey();
	}

	/**
	* Returns the proof address of this user profile.
	*
	* @return the proof address of this user profile
	*/
	@Override
	public java.lang.String getProofAddress() {
		return _userProfile.getProofAddress();
	}

	/**
	* Returns the prov of this user profile.
	*
	* @return the prov of this user profile
	*/
	@Override
	public java.lang.String getProv() {
		return _userProfile.getProv();
	}

	/**
	* Returns the reverso ID of this user profile.
	*
	* @return the reverso ID of this user profile
	*/
	@Override
	public java.lang.String getReversoId() {
		return _userProfile.getReversoId();
	}

	/**
	* Returns the selfie of this user profile.
	*
	* @return the selfie of this user profile
	*/
	@Override
	public java.lang.String getSelfie() {
		return _userProfile.getSelfie();
	}

	/**
	* Returns the street1 of this user profile.
	*
	* @return the street1 of this user profile
	*/
	@Override
	public java.lang.String getStreet1() {
		return _userProfile.getStreet1();
	}

	/**
	* Returns the street2 of this user profile.
	*
	* @return the street2 of this user profile
	*/
	@Override
	public java.lang.String getStreet2() {
		return _userProfile.getStreet2();
	}

	/**
	* Returns the user ID of this user profile.
	*
	* @return the user ID of this user profile
	*/
	@Override
	public java.lang.String getUserId() {
		return _userProfile.getUserId();
	}

	/**
	* Returns the uuid of this user profile.
	*
	* @return the uuid of this user profile
	*/
	@Override
	public java.lang.String getUuid() {
		return _userProfile.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userProfile.toXmlString();
	}

	@Override
	public user.profile.model.UserProfile toEscapedModel() {
		return new UserProfileWrapper(_userProfile.toEscapedModel());
	}

	@Override
	public user.profile.model.UserProfile toUnescapedModel() {
		return new UserProfileWrapper(_userProfile.toUnescapedModel());
	}

	@Override
	public void persist() {
		_userProfile.persist();
	}

	/**
	* Sets the anverso ID of this user profile.
	*
	* @param anversoId the anverso ID of this user profile
	*/
	@Override
	public void setAnversoId(java.lang.String anversoId) {
		_userProfile.setAnversoId(anversoId);
	}

	/**
	* Sets the approved of this user profile.
	*
	* @param approved the approved of this user profile
	*/
	@Override
	public void setApproved(java.lang.Boolean approved) {
		_userProfile.setApproved(approved);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userProfile.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this user profile.
	*
	* @param city the city of this user profile
	*/
	@Override
	public void setCity(java.lang.String city) {
		_userProfile.setCity(city);
	}

	/**
	* Sets the country of this user profile.
	*
	* @param country the country of this user profile
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_userProfile.setCountry(country);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userProfile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the home number of this user profile.
	*
	* @param homeNumber the home number of this user profile
	*/
	@Override
	public void setHomeNumber(java.lang.String homeNumber) {
		_userProfile.setHomeNumber(homeNumber);
	}

	/**
	* Sets the id number of this user profile.
	*
	* @param idNumber the id number of this user profile
	*/
	@Override
	public void setIdNumber(java.lang.String idNumber) {
		_userProfile.setIdNumber(idNumber);
	}

	/**
	* Sets the id type of this user profile.
	*
	* @param idType the id type of this user profile
	*/
	@Override
	public void setIdType(java.lang.String idType) {
		_userProfile.setIdType(idType);
	}

	@Override
	public void setNew(boolean n) {
		_userProfile.setNew(n);
	}

	/**
	* Sets the phone number of this user profile.
	*
	* @param phoneNumber the phone number of this user profile
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_userProfile.setPhoneNumber(phoneNumber);
	}

	/**
	* Sets the postal code of this user profile.
	*
	* @param postalCode the postal code of this user profile
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_userProfile.setPostalCode(postalCode);
	}

	/**
	* Sets the primary key of this user profile.
	*
	* @param primaryKey the primary key of this user profile
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userProfile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proof address of this user profile.
	*
	* @param proofAddress the proof address of this user profile
	*/
	@Override
	public void setProofAddress(java.lang.String proofAddress) {
		_userProfile.setProofAddress(proofAddress);
	}

	/**
	* Sets the prov of this user profile.
	*
	* @param prov the prov of this user profile
	*/
	@Override
	public void setProv(java.lang.String prov) {
		_userProfile.setProv(prov);
	}

	/**
	* Sets the reverso ID of this user profile.
	*
	* @param reversoId the reverso ID of this user profile
	*/
	@Override
	public void setReversoId(java.lang.String reversoId) {
		_userProfile.setReversoId(reversoId);
	}

	/**
	* Sets the selfie of this user profile.
	*
	* @param selfie the selfie of this user profile
	*/
	@Override
	public void setSelfie(java.lang.String selfie) {
		_userProfile.setSelfie(selfie);
	}

	/**
	* Sets the street1 of this user profile.
	*
	* @param street1 the street1 of this user profile
	*/
	@Override
	public void setStreet1(java.lang.String street1) {
		_userProfile.setStreet1(street1);
	}

	/**
	* Sets the street2 of this user profile.
	*
	* @param street2 the street2 of this user profile
	*/
	@Override
	public void setStreet2(java.lang.String street2) {
		_userProfile.setStreet2(street2);
	}

	/**
	* Sets the user ID of this user profile.
	*
	* @param userId the user ID of this user profile
	*/
	@Override
	public void setUserId(java.lang.String userId) {
		_userProfile.setUserId(userId);
	}

	/**
	* Sets the uuid of this user profile.
	*
	* @param uuid the uuid of this user profile
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userProfile.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserProfileWrapper)) {
			return false;
		}

		UserProfileWrapper userProfileWrapper = (UserProfileWrapper)obj;

		if (Objects.equals(_userProfile, userProfileWrapper._userProfile)) {
			return true;
		}

		return false;
	}

	@Override
	public UserProfile getWrappedModel() {
		return _userProfile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userProfile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userProfile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userProfile.resetOriginalValues();
	}

	private final UserProfile _userProfile;
}