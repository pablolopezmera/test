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

package profile.model;

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
 * This class is a wrapper for {@link DocumentsProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfile
 * @generated
 */
@ProviderType
public class DocumentsProfileWrapper implements DocumentsProfile,
	ModelWrapper<DocumentsProfile> {
	public DocumentsProfileWrapper(DocumentsProfile documentsProfile) {
		_documentsProfile = documentsProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentsProfile.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentsProfile.class.getName();
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
	}

	@Override
	public boolean isCachedModel() {
		return _documentsProfile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _documentsProfile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _documentsProfile.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _documentsProfile.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<profile.model.DocumentsProfile> toCacheModel() {
		return _documentsProfile.toCacheModel();
	}

	@Override
	public int compareTo(profile.model.DocumentsProfile documentsProfile) {
		return _documentsProfile.compareTo(documentsProfile);
	}

	@Override
	public int hashCode() {
		return _documentsProfile.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentsProfile.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentsProfileWrapper((DocumentsProfile)_documentsProfile.clone());
	}

	/**
	* Returns the anverso ID of this documents profile.
	*
	* @return the anverso ID of this documents profile
	*/
	@Override
	public java.lang.String getAnversoId() {
		return _documentsProfile.getAnversoId();
	}

	/**
	* Returns the primary key of this documents profile.
	*
	* @return the primary key of this documents profile
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _documentsProfile.getPrimaryKey();
	}

	/**
	* Returns the proof address of this documents profile.
	*
	* @return the proof address of this documents profile
	*/
	@Override
	public java.lang.String getProofAddress() {
		return _documentsProfile.getProofAddress();
	}

	/**
	* Returns the reverso ID of this documents profile.
	*
	* @return the reverso ID of this documents profile
	*/
	@Override
	public java.lang.String getReversoId() {
		return _documentsProfile.getReversoId();
	}

	/**
	* Returns the selfie of this documents profile.
	*
	* @return the selfie of this documents profile
	*/
	@Override
	public java.lang.String getSelfie() {
		return _documentsProfile.getSelfie();
	}

	/**
	* Returns the user ID of this documents profile.
	*
	* @return the user ID of this documents profile
	*/
	@Override
	public java.lang.String getUserId() {
		return _documentsProfile.getUserId();
	}

	/**
	* Returns the uuid of this documents profile.
	*
	* @return the uuid of this documents profile
	*/
	@Override
	public java.lang.String getUuid() {
		return _documentsProfile.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _documentsProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _documentsProfile.toXmlString();
	}

	@Override
	public profile.model.DocumentsProfile toEscapedModel() {
		return new DocumentsProfileWrapper(_documentsProfile.toEscapedModel());
	}

	@Override
	public profile.model.DocumentsProfile toUnescapedModel() {
		return new DocumentsProfileWrapper(_documentsProfile.toUnescapedModel());
	}

	@Override
	public void persist() {
		_documentsProfile.persist();
	}

	/**
	* Sets the anverso ID of this documents profile.
	*
	* @param anversoId the anverso ID of this documents profile
	*/
	@Override
	public void setAnversoId(java.lang.String anversoId) {
		_documentsProfile.setAnversoId(anversoId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentsProfile.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_documentsProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_documentsProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_documentsProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_documentsProfile.setNew(n);
	}

	/**
	* Sets the primary key of this documents profile.
	*
	* @param primaryKey the primary key of this documents profile
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_documentsProfile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_documentsProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proof address of this documents profile.
	*
	* @param proofAddress the proof address of this documents profile
	*/
	@Override
	public void setProofAddress(java.lang.String proofAddress) {
		_documentsProfile.setProofAddress(proofAddress);
	}

	/**
	* Sets the reverso ID of this documents profile.
	*
	* @param reversoId the reverso ID of this documents profile
	*/
	@Override
	public void setReversoId(java.lang.String reversoId) {
		_documentsProfile.setReversoId(reversoId);
	}

	/**
	* Sets the selfie of this documents profile.
	*
	* @param selfie the selfie of this documents profile
	*/
	@Override
	public void setSelfie(java.lang.String selfie) {
		_documentsProfile.setSelfie(selfie);
	}

	/**
	* Sets the user ID of this documents profile.
	*
	* @param userId the user ID of this documents profile
	*/
	@Override
	public void setUserId(java.lang.String userId) {
		_documentsProfile.setUserId(userId);
	}

	/**
	* Sets the uuid of this documents profile.
	*
	* @param uuid the uuid of this documents profile
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_documentsProfile.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentsProfileWrapper)) {
			return false;
		}

		DocumentsProfileWrapper documentsProfileWrapper = (DocumentsProfileWrapper)obj;

		if (Objects.equals(_documentsProfile,
					documentsProfileWrapper._documentsProfile)) {
			return true;
		}

		return false;
	}

	@Override
	public DocumentsProfile getWrappedModel() {
		return _documentsProfile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _documentsProfile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _documentsProfile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_documentsProfile.resetOriginalValues();
	}

	private final DocumentsProfile _documentsProfile;
}