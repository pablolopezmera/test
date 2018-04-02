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

package profile.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import profile.model.DocumentsProfile;

import java.util.List;

/**
 * The persistence utility for the documents profile service. This utility wraps {@link profile.service.persistence.impl.DocumentsProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfilePersistence
 * @see profile.service.persistence.impl.DocumentsProfilePersistenceImpl
 * @generated
 */
@ProviderType
public class DocumentsProfileUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DocumentsProfile documentsProfile) {
		getPersistence().clearCache(documentsProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentsProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentsProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentsProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentsProfile update(DocumentsProfile documentsProfile) {
		return getPersistence().update(documentsProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentsProfile update(DocumentsProfile documentsProfile,
		ServiceContext serviceContext) {
		return getPersistence().update(documentsProfile, serviceContext);
	}

	/**
	* Returns all the documents profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching documents profiles
	*/
	public static List<DocumentsProfile> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the documents profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @return the range of matching documents profiles
	*/
	public static List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the documents profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching documents profiles
	*/
	public static List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the documents profiles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching documents profiles
	*/
	public static List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public static DocumentsProfile findByUuid_First(java.lang.String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public static DocumentsProfile fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public static DocumentsProfile findByUuid_Last(java.lang.String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public static DocumentsProfile fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the documents profiles before and after the current documents profile in the ordered set where uuid = &#63;.
	*
	* @param userId the primary key of the current documents profile
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next documents profile
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public static DocumentsProfile[] findByUuid_PrevAndNext(
		java.lang.String userId, java.lang.String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence()
				   .findByUuid_PrevAndNext(userId, uuid, orderByComparator);
	}

	/**
	* Removes all the documents profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of documents profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching documents profiles
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the documents profile where userId = &#63; or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public static DocumentsProfile findByUserId(java.lang.String userId)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public static DocumentsProfile fetchByUserId(java.lang.String userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public static DocumentsProfile fetchByUserId(java.lang.String userId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the documents profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the documents profile that was removed
	*/
	public static DocumentsProfile removeByUserId(java.lang.String userId)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of documents profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching documents profiles
	*/
	public static int countByUserId(java.lang.String userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the documents profile in the entity cache if it is enabled.
	*
	* @param documentsProfile the documents profile
	*/
	public static void cacheResult(DocumentsProfile documentsProfile) {
		getPersistence().cacheResult(documentsProfile);
	}

	/**
	* Caches the documents profiles in the entity cache if it is enabled.
	*
	* @param documentsProfiles the documents profiles
	*/
	public static void cacheResult(List<DocumentsProfile> documentsProfiles) {
		getPersistence().cacheResult(documentsProfiles);
	}

	/**
	* Creates a new documents profile with the primary key. Does not add the documents profile to the database.
	*
	* @param userId the primary key for the new documents profile
	* @return the new documents profile
	*/
	public static DocumentsProfile create(java.lang.String userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the documents profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile that was removed
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public static DocumentsProfile remove(java.lang.String userId)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().remove(userId);
	}

	public static DocumentsProfile updateImpl(DocumentsProfile documentsProfile) {
		return getPersistence().updateImpl(documentsProfile);
	}

	/**
	* Returns the documents profile with the primary key or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public static DocumentsProfile findByPrimaryKey(java.lang.String userId)
		throws profile.exception.NoSuchDocumentsProfileException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the documents profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile, or <code>null</code> if a documents profile with the primary key could not be found
	*/
	public static DocumentsProfile fetchByPrimaryKey(java.lang.String userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	public static java.util.Map<java.io.Serializable, DocumentsProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the documents profiles.
	*
	* @return the documents profiles
	*/
	public static List<DocumentsProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the documents profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @return the range of documents profiles
	*/
	public static List<DocumentsProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the documents profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of documents profiles
	*/
	public static List<DocumentsProfile> findAll(int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the documents profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentsProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of documents profiles
	* @param end the upper bound of the range of documents profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of documents profiles
	*/
	public static List<DocumentsProfile> findAll(int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the documents profiles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of documents profiles.
	*
	* @return the number of documents profiles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DocumentsProfilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentsProfilePersistence, DocumentsProfilePersistence> _serviceTracker =
		ServiceTrackerFactory.open(DocumentsProfilePersistence.class);
}