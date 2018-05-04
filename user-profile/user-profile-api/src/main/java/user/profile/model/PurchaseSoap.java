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

import user.profile.service.persistence.PurchasePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link user.profile.service.http.PurchaseServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see user.profile.service.http.PurchaseServiceSoap
 * @generated
 */
@ProviderType
public class PurchaseSoap implements Serializable {
	public static PurchaseSoap toSoapModel(Purchase model) {
		PurchaseSoap soapModel = new PurchaseSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setScreenname(model.getScreenname());
		soapModel.setHash(model.getHash());
		soapModel.setDate_time(model.getDate_time());
		soapModel.setCurr_from(model.getCurr_from());
		soapModel.setValue_from(model.getValue_from());
		soapModel.setCurr_to(model.getCurr_to());
		soapModel.setValue_to(model.getValue_to());
		soapModel.setStatus(model.getStatus());
		soapModel.setEwallet(model.getEwallet());

		return soapModel;
	}

	public static PurchaseSoap[] toSoapModels(Purchase[] models) {
		PurchaseSoap[] soapModels = new PurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[][] toSoapModels(Purchase[][] models) {
		PurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[] toSoapModels(List<Purchase> models) {
		List<PurchaseSoap> soapModels = new ArrayList<PurchaseSoap>(models.size());

		for (Purchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseSoap[soapModels.size()]);
	}

	public PurchaseSoap() {
	}

	public PurchasePK getPrimaryKey() {
		return new PurchasePK(_screenname, _hash);
	}

	public void setPrimaryKey(PurchasePK pk) {
		setScreenname(pk.screenname);
		setHash(pk.hash);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getScreenname() {
		return _screenname;
	}

	public void setScreenname(String screenname) {
		_screenname = screenname;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	public Date getDate_time() {
		return _date_time;
	}

	public void setDate_time(Date date_time) {
		_date_time = date_time;
	}

	public String getCurr_from() {
		return _curr_from;
	}

	public void setCurr_from(String curr_from) {
		_curr_from = curr_from;
	}

	public String getValue_from() {
		return _value_from;
	}

	public void setValue_from(String value_from) {
		_value_from = value_from;
	}

	public String getCurr_to() {
		return _curr_to;
	}

	public void setCurr_to(String curr_to) {
		_curr_to = curr_to;
	}

	public String getValue_to() {
		return _value_to;
	}

	public void setValue_to(String value_to) {
		_value_to = value_to;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getEwallet() {
		return _ewallet;
	}

	public void setEwallet(String ewallet) {
		_ewallet = ewallet;
	}

	private String _uuid;
	private String _screenname;
	private String _hash;
	private Date _date_time;
	private String _curr_from;
	private String _value_from;
	private String _curr_to;
	private String _value_to;
	private String _status;
	private String _ewallet;
}