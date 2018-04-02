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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link profile.service.http.DocumentsProfileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see profile.service.http.DocumentsProfileServiceSoap
 * @generated
 */
@ProviderType
public class DocumentsProfileSoap implements Serializable {
	public static DocumentsProfileSoap toSoapModel(DocumentsProfile model) {
		DocumentsProfileSoap soapModel = new DocumentsProfileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setAnversoId(model.getAnversoId());
		soapModel.setReversoId(model.getReversoId());
		soapModel.setSelfie(model.getSelfie());
		soapModel.setProofAddress(model.getProofAddress());

		return soapModel;
	}

	public static DocumentsProfileSoap[] toSoapModels(DocumentsProfile[] models) {
		DocumentsProfileSoap[] soapModels = new DocumentsProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentsProfileSoap[][] toSoapModels(
		DocumentsProfile[][] models) {
		DocumentsProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentsProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentsProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentsProfileSoap[] toSoapModels(
		List<DocumentsProfile> models) {
		List<DocumentsProfileSoap> soapModels = new ArrayList<DocumentsProfileSoap>(models.size());

		for (DocumentsProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentsProfileSoap[soapModels.size()]);
	}

	public DocumentsProfileSoap() {
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

	private String _uuid;
	private String _userId;
	private String _anversoId;
	private String _reversoId;
	private String _selfie;
	private String _proofAddress;
}