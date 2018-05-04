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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Purchase service. Represents a row in the &quot;UserProfile_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseModel
 * @see user.profile.model.impl.PurchaseImpl
 * @see user.profile.model.impl.PurchaseModelImpl
 * @generated
 */
@ImplementationClassName("user.profile.model.impl.PurchaseImpl")
@ProviderType
public interface Purchase extends PurchaseModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link user.profile.model.impl.PurchaseImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Purchase, String> SCREENNAME_ACCESSOR = new Accessor<Purchase, String>() {
			@Override
			public String get(Purchase purchase) {
				return purchase.getScreenname();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Purchase> getTypeClass() {
				return Purchase.class;
			}
		};

	public static final Accessor<Purchase, String> HASH_ACCESSOR = new Accessor<Purchase, String>() {
			@Override
			public String get(Purchase purchase) {
				return purchase.getHash();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Purchase> getTypeClass() {
				return Purchase.class;
			}
		};
}