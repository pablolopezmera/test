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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import profile.exception.NoSuchDocumentsProfileException;

import profile.model.DocumentsProfile;

/**
 * The persistence interface for the documents profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see profile.service.persistence.impl.DocumentsProfilePersistenceImpl
 * @see DocumentsProfileUtil
 * @generated
 */
@ProviderType
public interface DocumentsProfilePersistence extends BasePersistence<DocumentsProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentsProfileUtil} to access the documents profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the documents profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching documents profiles
	*/
	public java.util.List<DocumentsProfile> findByUuid(java.lang.String uuid);

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
	public java.util.List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator);

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
	public java.util.List<DocumentsProfile> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public DocumentsProfile findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException;

	/**
	* Returns the first documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public DocumentsProfile fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator);

	/**
	* Returns the last documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public DocumentsProfile findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException;

	/**
	* Returns the last documents profile in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public DocumentsProfile fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator);

	/**
	* Returns the documents profiles before and after the current documents profile in the ordered set where uuid = &#63;.
	*
	* @param userId the primary key of the current documents profile
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next documents profile
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public DocumentsProfile[] findByUuid_PrevAndNext(java.lang.String userId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException;

	/**
	* Removes all the documents profiles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of documents profiles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching documents profiles
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the documents profile where userId = &#63; or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching documents profile
	* @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	*/
	public DocumentsProfile findByUserId(java.lang.String userId)
		throws NoSuchDocumentsProfileException;

	/**
	* Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public DocumentsProfile fetchByUserId(java.lang.String userId);

	/**
	* Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	*/
	public DocumentsProfile fetchByUserId(java.lang.String userId,
		boolean retrieveFromCache);

	/**
	* Removes the documents profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the documents profile that was removed
	*/
	public DocumentsProfile removeByUserId(java.lang.String userId)
		throws NoSuchDocumentsProfileException;

	/**
	* Returns the number of documents profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching documents profiles
	*/
	public int countByUserId(java.lang.String userId);

	/**
	* Caches the documents profile in the entity cache if it is enabled.
	*
	* @param documentsProfile the documents profile
	*/
	public void cacheResult(DocumentsProfile documentsProfile);

	/**
	* Caches the documents profiles in the entity cache if it is enabled.
	*
	* @param documentsProfiles the documents profiles
	*/
	public void cacheResult(java.util.List<DocumentsProfile> documentsProfiles);

	/**
	* Creates a new documents profile with the primary key. Does not add the documents profile to the database.
	*
	* @param userId the primary key for the new documents profile
	* @return the new documents profile
	*/
	public DocumentsProfile create(java.lang.String userId);

	/**
	* Removes the documents profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile that was removed
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public DocumentsProfile remove(java.lang.String userId)
		throws NoSuchDocumentsProfileException;

	public DocumentsProfile updateImpl(DocumentsProfile documentsProfile);

	/**
	* Returns the documents profile with the primary key or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile
	* @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	*/
	public DocumentsProfile findByPrimaryKey(java.lang.String userId)
		throws NoSuchDocumentsProfileException;

	/**
	* Returns the documents profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the documents profile
	* @return the documents profile, or <code>null</code> if a documents profile with the primary key could not be found
	*/
	public DocumentsProfile fetchByPrimaryKey(java.lang.String userId);

	@Override
	public java.util.Map<java.io.Serializable, DocumentsProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the documents profiles.
	*
	* @return the documents profiles
	*/
	public java.util.List<DocumentsProfile> findAll();

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
	public java.util.List<DocumentsProfile> findAll(int start, int end);

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
	public java.util.List<DocumentsProfile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator);

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
	public java.util.List<DocumentsProfile> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the documents profiles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of documents profiles.
	*
	* @return the number of documents profiles
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}