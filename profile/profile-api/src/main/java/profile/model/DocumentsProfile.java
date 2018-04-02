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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DocumentsProfile service. Represents a row in the &quot;DocumentsProfile_DocumentsProfile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfileModel
 * @see profile.model.impl.DocumentsProfileImpl
 * @see profile.model.impl.DocumentsProfileModelImpl
 * @generated
 */
@ImplementationClassName("profile.model.impl.DocumentsProfileImpl")
@ProviderType
public interface DocumentsProfile extends DocumentsProfileModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link profile.model.impl.DocumentsProfileImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DocumentsProfile, String> USER_ID_ACCESSOR = new Accessor<DocumentsProfile, String>() {
			@Override
			public String get(DocumentsProfile documentsProfile) {
				return documentsProfile.getUserId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DocumentsProfile> getTypeClass() {
				return DocumentsProfile.class;
			}
		};
}