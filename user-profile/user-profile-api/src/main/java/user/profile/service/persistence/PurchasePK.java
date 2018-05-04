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

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PurchasePK implements Comparable<PurchasePK>, Serializable {
	public String screenname;
	public String hash;

	public PurchasePK() {
	}

	public PurchasePK(String screenname, String hash) {
		this.screenname = screenname;
		this.hash = hash;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public int compareTo(PurchasePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = screenname.compareTo(pk.screenname);

		if (value != 0) {
			return value;
		}

		value = hash.compareTo(pk.hash);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PurchasePK)) {
			return false;
		}

		PurchasePK pk = (PurchasePK)obj;

		if ((screenname.equals(pk.screenname)) && (hash.equals(pk.hash))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, screenname);
		hashCode = HashUtil.hash(hashCode, hash);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("screenname");
		sb.append(StringPool.EQUAL);
		sb.append(screenname);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("hash");
		sb.append(StringPool.EQUAL);
		sb.append(hash);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}