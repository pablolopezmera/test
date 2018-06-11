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

package user.profile.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import user.profile.model.UserProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserProfile
 * @generated
 */
@ProviderType
public class UserProfileCacheModel implements CacheModel<UserProfile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserProfileCacheModel)) {
			return false;
		}

		UserProfileCacheModel userProfileCacheModel = (UserProfileCacheModel)obj;

		if (userId.equals(userProfileCacheModel.userId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", anversoId=");
		sb.append(anversoId);
		sb.append(", reversoId=");
		sb.append(reversoId);
		sb.append(", selfie=");
		sb.append(selfie);
		sb.append(", proofAddress=");
		sb.append(proofAddress);
		sb.append(", idType=");
		sb.append(idType);
		sb.append(", idNumber=");
		sb.append(idNumber);
		sb.append(", country=");
		sb.append(country);
		sb.append(", countryDescription=");
		sb.append(countryDescription);
		sb.append(", prov=");
		sb.append(prov);
		sb.append(", city=");
		sb.append(city);
		sb.append(", street1=");
		sb.append(street1);
		sb.append(", street2=");
		sb.append(street2);
		sb.append(", homeNumber=");
		sb.append(homeNumber);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserProfile toEntityModel() {
		UserProfileImpl userProfileImpl = new UserProfileImpl();

		if (uuid == null) {
			userProfileImpl.setUuid(StringPool.BLANK);
		}
		else {
			userProfileImpl.setUuid(uuid);
		}

		if (userId == null) {
			userProfileImpl.setUserId(StringPool.BLANK);
		}
		else {
			userProfileImpl.setUserId(userId);
		}

		if (anversoId == null) {
			userProfileImpl.setAnversoId(StringPool.BLANK);
		}
		else {
			userProfileImpl.setAnversoId(anversoId);
		}

		if (reversoId == null) {
			userProfileImpl.setReversoId(StringPool.BLANK);
		}
		else {
			userProfileImpl.setReversoId(reversoId);
		}

		if (selfie == null) {
			userProfileImpl.setSelfie(StringPool.BLANK);
		}
		else {
			userProfileImpl.setSelfie(selfie);
		}

		if (proofAddress == null) {
			userProfileImpl.setProofAddress(StringPool.BLANK);
		}
		else {
			userProfileImpl.setProofAddress(proofAddress);
		}

		if (idType == null) {
			userProfileImpl.setIdType(StringPool.BLANK);
		}
		else {
			userProfileImpl.setIdType(idType);
		}

		if (idNumber == null) {
			userProfileImpl.setIdNumber(StringPool.BLANK);
		}
		else {
			userProfileImpl.setIdNumber(idNumber);
		}

		if (country == null) {
			userProfileImpl.setCountry(StringPool.BLANK);
		}
		else {
			userProfileImpl.setCountry(country);
		}

		if (countryDescription == null) {
			userProfileImpl.setCountryDescription(StringPool.BLANK);
		}
		else {
			userProfileImpl.setCountryDescription(countryDescription);
		}

		if (prov == null) {
			userProfileImpl.setProv(StringPool.BLANK);
		}
		else {
			userProfileImpl.setProv(prov);
		}

		if (city == null) {
			userProfileImpl.setCity(StringPool.BLANK);
		}
		else {
			userProfileImpl.setCity(city);
		}

		if (street1 == null) {
			userProfileImpl.setStreet1(StringPool.BLANK);
		}
		else {
			userProfileImpl.setStreet1(street1);
		}

		if (street2 == null) {
			userProfileImpl.setStreet2(StringPool.BLANK);
		}
		else {
			userProfileImpl.setStreet2(street2);
		}

		if (homeNumber == null) {
			userProfileImpl.setHomeNumber(StringPool.BLANK);
		}
		else {
			userProfileImpl.setHomeNumber(homeNumber);
		}

		if (postalCode == null) {
			userProfileImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			userProfileImpl.setPostalCode(postalCode);
		}

		userProfileImpl.setApproved(approved);

		if (phoneNumber == null) {
			userProfileImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			userProfileImpl.setPhoneNumber(phoneNumber);
		}

		userProfileImpl.resetOriginalValues();

		return userProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userId = objectInput.readUTF();
		anversoId = objectInput.readUTF();
		reversoId = objectInput.readUTF();
		selfie = objectInput.readUTF();
		proofAddress = objectInput.readUTF();
		idType = objectInput.readUTF();
		idNumber = objectInput.readUTF();
		country = objectInput.readUTF();
		countryDescription = objectInput.readUTF();
		prov = objectInput.readUTF();
		city = objectInput.readUTF();
		street1 = objectInput.readUTF();
		street2 = objectInput.readUTF();
		homeNumber = objectInput.readUTF();
		postalCode = objectInput.readUTF();

		approved = objectInput.readBoolean();
		phoneNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (userId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userId);
		}

		if (anversoId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anversoId);
		}

		if (reversoId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reversoId);
		}

		if (selfie == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(selfie);
		}

		if (proofAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(proofAddress);
		}

		if (idType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idType);
		}

		if (idNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idNumber);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (countryDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryDescription);
		}

		if (prov == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prov);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (street1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street1);
		}

		if (street2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street2);
		}

		if (homeNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeNumber);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		objectOutput.writeBoolean(approved);

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}
	}

	public String uuid;
	public String userId;
	public String anversoId;
	public String reversoId;
	public String selfie;
	public String proofAddress;
	public String idType;
	public String idNumber;
	public String country;
	public String countryDescription;
	public String prov;
	public String city;
	public String street1;
	public String street2;
	public String homeNumber;
	public String postalCode;
	public boolean approved;
	public String phoneNumber;
}