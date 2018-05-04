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

import user.profile.model.Purchase;

import user.profile.service.persistence.PurchasePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
@ProviderType
public class PurchaseCacheModel implements CacheModel<Purchase>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)obj;

		if (purchasePK.equals(purchaseCacheModel.purchasePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchasePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", screenname=");
		sb.append(screenname);
		sb.append(", hash=");
		sb.append(hash);
		sb.append(", date_time=");
		sb.append(date_time);
		sb.append(", curr_from=");
		sb.append(curr_from);
		sb.append(", value_from=");
		sb.append(value_from);
		sb.append(", curr_to=");
		sb.append(curr_to);
		sb.append(", value_to=");
		sb.append(value_to);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ewallet=");
		sb.append(ewallet);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		if (uuid == null) {
			purchaseImpl.setUuid(StringPool.BLANK);
		}
		else {
			purchaseImpl.setUuid(uuid);
		}

		if (screenname == null) {
			purchaseImpl.setScreenname(StringPool.BLANK);
		}
		else {
			purchaseImpl.setScreenname(screenname);
		}

		if (hash == null) {
			purchaseImpl.setHash(StringPool.BLANK);
		}
		else {
			purchaseImpl.setHash(hash);
		}

		if (date_time == Long.MIN_VALUE) {
			purchaseImpl.setDate_time(null);
		}
		else {
			purchaseImpl.setDate_time(new Date(date_time));
		}

		if (curr_from == null) {
			purchaseImpl.setCurr_from(StringPool.BLANK);
		}
		else {
			purchaseImpl.setCurr_from(curr_from);
		}

		if (value_from == null) {
			purchaseImpl.setValue_from(StringPool.BLANK);
		}
		else {
			purchaseImpl.setValue_from(value_from);
		}

		if (curr_to == null) {
			purchaseImpl.setCurr_to(StringPool.BLANK);
		}
		else {
			purchaseImpl.setCurr_to(curr_to);
		}

		if (value_to == null) {
			purchaseImpl.setValue_to(StringPool.BLANK);
		}
		else {
			purchaseImpl.setValue_to(value_to);
		}

		if (status == null) {
			purchaseImpl.setStatus(StringPool.BLANK);
		}
		else {
			purchaseImpl.setStatus(status);
		}

		if (ewallet == null) {
			purchaseImpl.setEwallet(StringPool.BLANK);
		}
		else {
			purchaseImpl.setEwallet(ewallet);
		}

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		screenname = objectInput.readUTF();
		hash = objectInput.readUTF();
		date_time = objectInput.readLong();
		curr_from = objectInput.readUTF();
		value_from = objectInput.readUTF();
		curr_to = objectInput.readUTF();
		value_to = objectInput.readUTF();
		status = objectInput.readUTF();
		ewallet = objectInput.readUTF();

		purchasePK = new PurchasePK(screenname, hash);
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

		if (screenname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenname);
		}

		if (hash == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hash);
		}

		objectOutput.writeLong(date_time);

		if (curr_from == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(curr_from);
		}

		if (value_from == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value_from);
		}

		if (curr_to == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(curr_to);
		}

		if (value_to == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value_to);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (ewallet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ewallet);
		}
	}

	public String uuid;
	public String screenname;
	public String hash;
	public long date_time;
	public String curr_from;
	public String value_from;
	public String curr_to;
	public String value_to;
	public String status;
	public String ewallet;
	public transient PurchasePK purchasePK;
}