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

package profile.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DocumentsProfile. This utility wraps
 * {@link profile.service.impl.DocumentsProfileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfileLocalService
 * @see profile.service.base.DocumentsProfileLocalServiceBaseImpl
 * @see profile.service.impl.DocumentsProfileLocalServiceImpl
 * @generated
 */
@ProviderType
public class DocumentsProfileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link profile.service.impl.DocumentsProfileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of documents profiles.
	*
	* @return the number of documents profiles
	*/
	public static int getDocumentsProfilesCount() {
		return getService().getDocumentsProfilesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profile.model.impl.DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profile.model.impl.DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the documents profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link profile.model.impl.DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @return the range of documents profiles
	*/
	public static java.util.List<profile.model.DocumentsProfile> getDocumentsProfiles(
		int start, int end) {
		return getService().getDocumentsProfiles(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the documents profile to the database. Also notifies the appropriate model listeners.
	*
	* @param documentsProfile the documents profile
	* @return the documents profile that was added
	*/
	public static profile.model.DocumentsProfile addDocumentsProfile(
		profile.model.DocumentsProfile documentsProfile) {
		return getService().addDocumentsProfile(documentsProfile);
	}

	/**
	* Creates a new documents profile with the primary key. Does not add the documents profile to the database.
	*
	* @param userId the primary key for the new documents profile
	* @return the new documents profile
	*/
	public static profile.model.DocumentsProfile createDocumentsProfile(
		java.lang.String userId) {
		return getService().createDocumentsProfile(userId);
	}

	/**
	* Deletes the documents profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile that was removed
	* @throws PortalException if a documents profile with the primary key could not be found
	*/
	public static profile.model.DocumentsProfile deleteDocumentsProfile(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDocumentsProfile(userId);
	}

	/**
	* Deletes the documents profile from the database. Also notifies the appropriate model listeners.
	*
	* @param documentsProfile the documents profile
	* @return the documents profile that was removed
	*/
	public static profile.model.DocumentsProfile deleteDocumentsProfile(
		profile.model.DocumentsProfile documentsProfile) {
		return getService().deleteDocumentsProfile(documentsProfile);
	}

	public static profile.model.DocumentsProfile fetchDocumentsProfile(
		java.lang.String userId) {
		return getService().fetchDocumentsProfile(userId);
	}

	/**
	* Returns the documents profile with the primary key.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile
	* @throws PortalException if a documents profile with the primary key could not be found
	*/
	public static profile.model.DocumentsProfile getDocumentsProfile(
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDocumentsProfile(userId);
	}

	/**
	* Updates the documents profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentsProfile the documents profile
	* @return the documents profile that was updated
	*/
	public static profile.model.DocumentsProfile updateDocumentsProfile(
		profile.model.DocumentsProfile documentsProfile) {
		return getService().updateDocumentsProfile(documentsProfile);
	}

	public static DocumentsProfileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentsProfileLocalService, DocumentsProfileLocalService> _serviceTracker =
		ServiceTrackerFactory.open(DocumentsProfileLocalService.class);
}