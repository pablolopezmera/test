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

package profile.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import profile.exception.NoSuchDocumentsProfileException;

import profile.model.DocumentsProfile;

import profile.model.impl.DocumentsProfileImpl;
import profile.model.impl.DocumentsProfileModelImpl;

import profile.service.persistence.DocumentsProfilePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the documents profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsProfilePersistence
 * @see profile.service.persistence.DocumentsProfileUtil
 * @generated
 */
@ProviderType
public class DocumentsProfilePersistenceImpl extends BasePersistenceImpl<DocumentsProfile>
	implements DocumentsProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentsProfileUtil} to access the documents profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentsProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED,
			DocumentsProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED,
			DocumentsProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED,
			DocumentsProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED,
			DocumentsProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DocumentsProfileModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the documents profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching documents profiles
	 */
	@Override
	public List<DocumentsProfile> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocumentsProfile> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<DocumentsProfile> findByUuid(String uuid, int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<DocumentsProfile> findByUuid(String uuid, int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<DocumentsProfile> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentsProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentsProfile documentsProfile : list) {
					if (!Objects.equals(uuid, documentsProfile.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENTSPROFILE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocumentsProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<DocumentsProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentsProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first documents profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents profile
	 * @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile findByUuid_First(String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = fetchByUuid_First(uuid,
				orderByComparator);

		if (documentsProfile != null) {
			return documentsProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentsProfileException(msg.toString());
	}

	/**
	 * Returns the first documents profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents profile, or <code>null</code> if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile fetchByUuid_First(String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		List<DocumentsProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last documents profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents profile
	 * @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile findByUuid_Last(String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = fetchByUuid_Last(uuid,
				orderByComparator);

		if (documentsProfile != null) {
			return documentsProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocumentsProfileException(msg.toString());
	}

	/**
	 * Returns the last documents profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents profile, or <code>null</code> if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile fetchByUuid_Last(String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentsProfile> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DocumentsProfile[] findByUuid_PrevAndNext(String userId,
		String uuid, OrderByComparator<DocumentsProfile> orderByComparator)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			DocumentsProfile[] array = new DocumentsProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(session, documentsProfile, uuid,
					orderByComparator, true);

			array[1] = documentsProfile;

			array[2] = getByUuid_PrevAndNext(session, documentsProfile, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentsProfile getByUuid_PrevAndNext(Session session,
		DocumentsProfile documentsProfile, String uuid,
		OrderByComparator<DocumentsProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENTSPROFILE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DocumentsProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(documentsProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DocumentsProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documents profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentsProfile documentsProfile : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(documentsProfile);
		}
	}

	/**
	 * Returns the number of documents profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching documents profiles
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTSPROFILE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "documentsProfile.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "documentsProfile.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(documentsProfile.uuid IS NULL OR documentsProfile.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED,
			DocumentsProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId", new String[] { String.class.getName() },
			DocumentsProfileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns the documents profile where userId = &#63; or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching documents profile
	 * @throws NoSuchDocumentsProfileException if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile findByUserId(String userId)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = fetchByUserId(userId);

		if (documentsProfile == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDocumentsProfileException(msg.toString());
		}

		return documentsProfile;
	}

	/**
	 * Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile fetchByUserId(String userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the documents profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching documents profile, or <code>null</code> if a matching documents profile could not be found
	 */
	@Override
	public DocumentsProfile fetchByUserId(String userId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof DocumentsProfile) {
			DocumentsProfile documentsProfile = (DocumentsProfile)result;

			if (!Objects.equals(userId, documentsProfile.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOCUMENTSPROFILE_WHERE);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_USERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserId) {
					qPos.add(userId);
				}

				List<DocumentsProfile> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DocumentsProfilePersistenceImpl.fetchByUserId(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentsProfile documentsProfile = list.get(0);

					result = documentsProfile;

					cacheResult(documentsProfile);

					if ((documentsProfile.getUserId() == null) ||
							!documentsProfile.getUserId().equals(userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, documentsProfile);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DocumentsProfile)result;
		}
	}

	/**
	 * Removes the documents profile where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the documents profile that was removed
	 */
	@Override
	public DocumentsProfile removeByUserId(String userId)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = findByUserId(userId);

		return remove(documentsProfile);
	}

	/**
	 * Returns the number of documents profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching documents profiles
	 */
	@Override
	public int countByUserId(String userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTSPROFILE_WHERE);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_USERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserId) {
					qPos.add(userId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_1 = "documentsProfile.userId IS NULL";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "documentsProfile.userId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_3 = "(documentsProfile.userId IS NULL OR documentsProfile.userId = '')";

	public DocumentsProfilePersistenceImpl() {
		setModelClass(DocumentsProfile.class);
	}

	/**
	 * Caches the documents profile in the entity cache if it is enabled.
	 *
	 * @param documentsProfile the documents profile
	 */
	@Override
	public void cacheResult(DocumentsProfile documentsProfile) {
		entityCache.putResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileImpl.class, documentsProfile.getPrimaryKey(),
			documentsProfile);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { documentsProfile.getUserId() }, documentsProfile);

		documentsProfile.resetOriginalValues();
	}

	/**
	 * Caches the documents profiles in the entity cache if it is enabled.
	 *
	 * @param documentsProfiles the documents profiles
	 */
	@Override
	public void cacheResult(List<DocumentsProfile> documentsProfiles) {
		for (DocumentsProfile documentsProfile : documentsProfiles) {
			if (entityCache.getResult(
						DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsProfileImpl.class,
						documentsProfile.getPrimaryKey()) == null) {
				cacheResult(documentsProfile);
			}
			else {
				documentsProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all documents profiles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentsProfileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the documents profile.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentsProfile documentsProfile) {
		entityCache.removeResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileImpl.class, documentsProfile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DocumentsProfileModelImpl)documentsProfile);
	}

	@Override
	public void clearCache(List<DocumentsProfile> documentsProfiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentsProfile documentsProfile : documentsProfiles) {
			entityCache.removeResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsProfileImpl.class, documentsProfile.getPrimaryKey());

			clearUniqueFindersCache((DocumentsProfileModelImpl)documentsProfile);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentsProfileModelImpl documentsProfileModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { documentsProfileModelImpl.getUserId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				documentsProfileModelImpl);
		}
		else {
			if ((documentsProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentsProfileModelImpl.getUserId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					documentsProfileModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		DocumentsProfileModelImpl documentsProfileModelImpl) {
		Object[] args = new Object[] { documentsProfileModelImpl.getUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((documentsProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { documentsProfileModelImpl.getOriginalUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new documents profile with the primary key. Does not add the documents profile to the database.
	 *
	 * @param userId the primary key for the new documents profile
	 * @return the new documents profile
	 */
	@Override
	public DocumentsProfile create(String userId) {
		DocumentsProfile documentsProfile = new DocumentsProfileImpl();

		documentsProfile.setNew(true);
		documentsProfile.setPrimaryKey(userId);

		String uuid = PortalUUIDUtil.generate();

		documentsProfile.setUuid(uuid);

		return documentsProfile;
	}

	/**
	 * Removes the documents profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the documents profile
	 * @return the documents profile that was removed
	 * @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile remove(String userId)
		throws NoSuchDocumentsProfileException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the documents profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the documents profile
	 * @return the documents profile that was removed
	 * @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile remove(Serializable primaryKey)
		throws NoSuchDocumentsProfileException {
		Session session = null;

		try {
			session = openSession();

			DocumentsProfile documentsProfile = (DocumentsProfile)session.get(DocumentsProfileImpl.class,
					primaryKey);

			if (documentsProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentsProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documentsProfile);
		}
		catch (NoSuchDocumentsProfileException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DocumentsProfile removeImpl(DocumentsProfile documentsProfile) {
		documentsProfile = toUnwrappedModel(documentsProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentsProfile)) {
				documentsProfile = (DocumentsProfile)session.get(DocumentsProfileImpl.class,
						documentsProfile.getPrimaryKeyObj());
			}

			if (documentsProfile != null) {
				session.delete(documentsProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentsProfile != null) {
			clearCache(documentsProfile);
		}

		return documentsProfile;
	}

	@Override
	public DocumentsProfile updateImpl(DocumentsProfile documentsProfile) {
		documentsProfile = toUnwrappedModel(documentsProfile);

		boolean isNew = documentsProfile.isNew();

		DocumentsProfileModelImpl documentsProfileModelImpl = (DocumentsProfileModelImpl)documentsProfile;

		if (Validator.isNull(documentsProfile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			documentsProfile.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (documentsProfile.isNew()) {
				session.save(documentsProfile);

				documentsProfile.setNew(false);
			}
			else {
				documentsProfile = (DocumentsProfile)session.merge(documentsProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DocumentsProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((documentsProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentsProfileModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { documentsProfileModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
			DocumentsProfileImpl.class, documentsProfile.getPrimaryKey(),
			documentsProfile, false);

		clearUniqueFindersCache(documentsProfileModelImpl);
		cacheUniqueFindersCache(documentsProfileModelImpl, isNew);

		documentsProfile.resetOriginalValues();

		return documentsProfile;
	}

	protected DocumentsProfile toUnwrappedModel(
		DocumentsProfile documentsProfile) {
		if (documentsProfile instanceof DocumentsProfileImpl) {
			return documentsProfile;
		}

		DocumentsProfileImpl documentsProfileImpl = new DocumentsProfileImpl();

		documentsProfileImpl.setNew(documentsProfile.isNew());
		documentsProfileImpl.setPrimaryKey(documentsProfile.getPrimaryKey());

		documentsProfileImpl.setUuid(documentsProfile.getUuid());
		documentsProfileImpl.setUserId(documentsProfile.getUserId());
		documentsProfileImpl.setAnversoId(documentsProfile.getAnversoId());
		documentsProfileImpl.setReversoId(documentsProfile.getReversoId());
		documentsProfileImpl.setSelfie(documentsProfile.getSelfie());
		documentsProfileImpl.setProofAddress(documentsProfile.getProofAddress());

		return documentsProfileImpl;
	}

	/**
	 * Returns the documents profile with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents profile
	 * @return the documents profile
	 * @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentsProfileException {
		DocumentsProfile documentsProfile = fetchByPrimaryKey(primaryKey);

		if (documentsProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentsProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documentsProfile;
	}

	/**
	 * Returns the documents profile with the primary key or throws a {@link NoSuchDocumentsProfileException} if it could not be found.
	 *
	 * @param userId the primary key of the documents profile
	 * @return the documents profile
	 * @throws NoSuchDocumentsProfileException if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile findByPrimaryKey(String userId)
		throws NoSuchDocumentsProfileException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the documents profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents profile
	 * @return the documents profile, or <code>null</code> if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
				DocumentsProfileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DocumentsProfile documentsProfile = (DocumentsProfile)serializable;

		if (documentsProfile == null) {
			Session session = null;

			try {
				session = openSession();

				documentsProfile = (DocumentsProfile)session.get(DocumentsProfileImpl.class,
						primaryKey);

				if (documentsProfile != null) {
					cacheResult(documentsProfile);
				}
				else {
					entityCache.putResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
						DocumentsProfileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentsProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentsProfile;
	}

	/**
	 * Returns the documents profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the documents profile
	 * @return the documents profile, or <code>null</code> if a documents profile with the primary key could not be found
	 */
	@Override
	public DocumentsProfile fetchByPrimaryKey(String userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	@Override
	public Map<Serializable, DocumentsProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DocumentsProfile> map = new HashMap<Serializable, DocumentsProfile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DocumentsProfile documentsProfile = fetchByPrimaryKey(primaryKey);

			if (documentsProfile != null) {
				map.put(primaryKey, documentsProfile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentsProfileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DocumentsProfile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_DOCUMENTSPROFILE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DocumentsProfile documentsProfile : (List<DocumentsProfile>)q.list()) {
				map.put(documentsProfile.getPrimaryKeyObj(), documentsProfile);

				cacheResult(documentsProfile);

				uncachedPrimaryKeys.remove(documentsProfile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DocumentsProfileModelImpl.ENTITY_CACHE_ENABLED,
					DocumentsProfileImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the documents profiles.
	 *
	 * @return the documents profiles
	 */
	@Override
	public List<DocumentsProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocumentsProfile> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DocumentsProfile> findAll(int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DocumentsProfile> findAll(int start, int end,
		OrderByComparator<DocumentsProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DocumentsProfile> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentsProfile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENTSPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTSPROFILE;

				if (pagination) {
					sql = sql.concat(DocumentsProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentsProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentsProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the documents profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentsProfile documentsProfile : findAll()) {
			remove(documentsProfile);
		}
	}

	/**
	 * Returns the number of documents profiles.
	 *
	 * @return the number of documents profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTSPROFILE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentsProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the documents profile persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DocumentsProfileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DOCUMENTSPROFILE = "SELECT documentsProfile FROM DocumentsProfile documentsProfile";
	private static final String _SQL_SELECT_DOCUMENTSPROFILE_WHERE_PKS_IN = "SELECT documentsProfile FROM DocumentsProfile documentsProfile WHERE userId IN (";
	private static final String _SQL_SELECT_DOCUMENTSPROFILE_WHERE = "SELECT documentsProfile FROM DocumentsProfile documentsProfile WHERE ";
	private static final String _SQL_COUNT_DOCUMENTSPROFILE = "SELECT COUNT(documentsProfile) FROM DocumentsProfile documentsProfile";
	private static final String _SQL_COUNT_DOCUMENTSPROFILE_WHERE = "SELECT COUNT(documentsProfile) FROM DocumentsProfile documentsProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documentsProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocumentsProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DocumentsProfile exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DocumentsProfilePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}