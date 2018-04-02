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

package profile.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import profile.model.DocumentsProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DocumentsProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfile
 * @generated
 */
@ProviderType
public class DocumentsProfileCacheModel implements CacheModel<DocumentsProfile>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentsProfileCacheModel)) {
			return false;
		}

		DocumentsProfileCacheModel documentsProfileCacheModel = (DocumentsProfileCacheModel)obj;

		if (userId.equals(documentsProfileCacheModel.userId)) {
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
		StringBundler sb = new StringBundler(13);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentsProfile toEntityModel() {
		DocumentsProfileImpl documentsProfileImpl = new DocumentsProfileImpl();

		if (uuid == null) {
			documentsProfileImpl.setUuid(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setUuid(uuid);
		}

		if (userId == null) {
			documentsProfileImpl.setUserId(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setUserId(userId);
		}

		if (anversoId == null) {
			documentsProfileImpl.setAnversoId(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setAnversoId(anversoId);
		}

		if (reversoId == null) {
			documentsProfileImpl.setReversoId(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setReversoId(reversoId);
		}

		if (selfie == null) {
			documentsProfileImpl.setSelfie(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setSelfie(selfie);
		}

		if (proofAddress == null) {
			documentsProfileImpl.setProofAddress(StringPool.BLANK);
		}
		else {
			documentsProfileImpl.setProofAddress(proofAddress);
		}

		documentsProfileImpl.resetOriginalValues();

		return documentsProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userId = objectInput.readUTF();
		anversoId = objectInput.readUTF();
		reversoId = objectInput.readUTF();
		selfie = objectInput.readUTF();
		proofAddress = objectInput.readUTF();
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
	}

	public String uuid;
	public String userId;
	public String anversoId;
	public String reversoId;
	public String selfie;
	public String proofAddress;
}