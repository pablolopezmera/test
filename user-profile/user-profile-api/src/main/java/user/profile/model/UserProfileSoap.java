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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link user.profile.service.http.UserProfileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see user.profile.service.http.UserProfileServiceSoap
 * @generated
 */
@ProviderType
public class UserProfileSoap implements Serializable {
	public static UserProfileSoap toSoapModel(UserProfile model) {
		UserProfileSoap soapModel = new UserProfileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setAnversoId(model.getAnversoId());
		soapModel.setReversoId(model.getReversoId());
		soapModel.setSelfie(model.getSelfie());
		soapModel.setProofAddress(model.getProofAddress());
		soapModel.setIdType(model.getIdType());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setCountry(model.getCountry());
		soapModel.setProv(model.getProv());
		soapModel.setCity(model.getCity());
		soapModel.setStreet1(model.getStreet1());
		soapModel.setStreet2(model.getStreet2());
		soapModel.setHomeNumber(model.getHomeNumber());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setApproved(model.getApproved());

		return soapModel;
	}

	public static UserProfileSoap[] toSoapModels(UserProfile[] models) {
		UserProfileSoap[] soapModels = new UserProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserProfileSoap[][] toSoapModels(UserProfile[][] models) {
		UserProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserProfileSoap[] toSoapModels(List<UserProfile> models) {
		List<UserProfileSoap> soapModels = new ArrayList<UserProfileSoap>(models.size());

		for (UserProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserProfileSoap[soapModels.size()]);
	}

	public UserProfileSoap() {
	}

	public String getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(String pk) {
		setUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getAnversoId() {
		return _anversoId;
	}

	public void setAnversoId(String anversoId) {
		_anversoId = anversoId;
	}

	public String getReversoId() {
		return _reversoId;
	}

	public void setReversoId(String reversoId) {
		_reversoId = reversoId;
	}

	public String getSelfie() {
		return _selfie;
	}

	public void setSelfie(String selfie) {
		_selfie = selfie;
	}

	public String getProofAddress() {
		return _proofAddress;
	}

	public void setProofAddress(String proofAddress) {
		_proofAddress = proofAddress;
	}

	public String getIdType() {
		return _idType;
	}

	public void setIdType(String idType) {
		_idType = idType;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getProv() {
		return _prov;
	}

	public void setProv(String prov) {
		_prov = prov;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getStreet1() {
		return _street1;
	}

	public void setStreet1(String street1) {
		_street1 = street1;
	}

	public String getStreet2() {
		return _street2;
	}

	public void setStreet2(String street2) {
		_street2 = street2;
	}

	public String getHomeNumber() {
		return _homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		_homeNumber = homeNumber;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public Boolean getApproved() {
		return _approved;
	}

	public void setApproved(Boolean approved) {
		_approved = approved;
	}

	private String _uuid;
	private String _userId;
	private String _anversoId;
	private String _reversoId;
	private String _selfie;
	private String _proofAddress;
	private String _idType;
	private String _idNumber;
	private String _country;
	private String _prov;
	private String _city;
	private String _street1;
	private String _street2;
	private String _homeNumber;
	private String _postalCode;
	private Boolean _approved;
}