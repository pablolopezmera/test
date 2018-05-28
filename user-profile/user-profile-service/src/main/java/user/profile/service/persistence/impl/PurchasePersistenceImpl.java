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

package user.profile.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import user.profile.exception.NoSuchPurchaseException;

import user.profile.model.Purchase;
import user.profile.model.impl.PurchaseImpl;
import user.profile.model.impl.PurchaseModelImpl;

import user.profile.service.persistence.PurchasePK;
import user.profile.service.persistence.PurchasePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchasePersistence
 * @see user.profile.service.persistence.PurchaseUtil
 * @generated
 */
@ProviderType
public class PurchasePersistenceImpl extends BasePersistenceImpl<Purchase>
	implements PurchasePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PurchaseUtil} to access the purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PurchaseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PurchaseModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByUuid(String uuid, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean retrieveFromCache) {
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

		List<Purchase> list = null;

		if (retrieveFromCache) {
			list = (List<Purchase>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (!Objects.equals(uuid, purchase.getUuid())) {
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

			query.append(_SQL_SELECT_PURCHASE_WHERE);

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
				query.append(PurchaseModelImpl.ORDER_BY_JPQL);
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
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_First(String uuid,
		OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = fetchByUuid_First(uuid, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseException(msg.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_First(String uuid,
		OrderByComparator<Purchase> orderByComparator) {
		List<Purchase> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByUuid_Last(String uuid,
		OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = fetchByUuid_Last(uuid, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseException(msg.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByUuid_Last(String uuid,
		OrderByComparator<Purchase> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where uuid = &#63;.
	 *
	 * @param purchasePK the primary key of the current purchase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByUuid_PrevAndNext(PurchasePK purchasePK,
		String uuid, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = findByPrimaryKey(purchasePK);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByUuid_PrevAndNext(session, purchase, uuid,
					orderByComparator, true);

			array[1] = purchase;

			array[2] = getByUuid_PrevAndNext(session, purchase, uuid,
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

	protected Purchase getByUuid_PrevAndNext(Session session,
		Purchase purchase, String uuid,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PURCHASE_WHERE);

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
			query.append(PurchaseModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(purchase);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Purchase> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Purchase purchase : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching purchases
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PURCHASE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "purchase.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "purchase.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(purchase.uuid IS NULL OR purchase.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREENNAME =
		new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByscreenname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENNAME =
		new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, PurchaseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscreenname",
			new String[] { String.class.getName() },
			PurchaseModelImpl.SCREENNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREENNAME = new FinderPath(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscreenname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the purchases where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByscreenname(String screenname) {
		return findByscreenname(screenname, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where screenname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenname the screenname
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByscreenname(String screenname, int start, int end) {
		return findByscreenname(screenname, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where screenname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenname the screenname
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByscreenname(String screenname, int start,
		int end, OrderByComparator<Purchase> orderByComparator) {
		return findByscreenname(screenname, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where screenname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenname the screenname
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByscreenname(String screenname, int start,
		int end, OrderByComparator<Purchase> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENNAME;
			finderArgs = new Object[] { screenname };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREENNAME;
			finderArgs = new Object[] { screenname, start, end, orderByComparator };
		}

		List<Purchase> list = null;

		if (retrieveFromCache) {
			list = (List<Purchase>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (!Objects.equals(screenname, purchase.getScreenname())) {
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

			query.append(_SQL_SELECT_PURCHASE_WHERE);

			boolean bindScreenname = false;

			if (screenname == null) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_1);
			}
			else if (screenname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenname = true;

				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenname) {
					qPos.add(screenname);
				}

				if (!pagination) {
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first purchase in the ordered set where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByscreenname_First(String screenname,
		OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = fetchByscreenname_First(screenname,
				orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screenname=");
		msg.append(screenname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseException(msg.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByscreenname_First(String screenname,
		OrderByComparator<Purchase> orderByComparator) {
		List<Purchase> list = findByscreenname(screenname, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByscreenname_Last(String screenname,
		OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = fetchByscreenname_Last(screenname, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screenname=");
		msg.append(screenname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseException(msg.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByscreenname_Last(String screenname,
		OrderByComparator<Purchase> orderByComparator) {
		int count = countByscreenname(screenname);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByscreenname(screenname, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where screenname = &#63;.
	 *
	 * @param purchasePK the primary key of the current purchase
	 * @param screenname the screenname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByscreenname_PrevAndNext(PurchasePK purchasePK,
		String screenname, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {
		Purchase purchase = findByPrimaryKey(purchasePK);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByscreenname_PrevAndNext(session, purchase,
					screenname, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByscreenname_PrevAndNext(session, purchase,
					screenname, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByscreenname_PrevAndNext(Session session,
		Purchase purchase, String screenname,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PURCHASE_WHERE);

		boolean bindScreenname = false;

		if (screenname == null) {
			query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_1);
		}
		else if (screenname.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenname = true;

			query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
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
			query.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScreenname) {
			qPos.add(screenname);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(purchase);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Purchase> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where screenname = &#63; from the database.
	 *
	 * @param screenname the screenname
	 */
	@Override
	public void removeByscreenname(String screenname) {
		for (Purchase purchase : findByscreenname(screenname,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where screenname = &#63;.
	 *
	 * @param screenname the screenname
	 * @return the number of matching purchases
	 */
	@Override
	public int countByscreenname(String screenname) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCREENNAME;

		Object[] finderArgs = new Object[] { screenname };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PURCHASE_WHERE);

			boolean bindScreenname = false;

			if (screenname == null) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_1);
			}
			else if (screenname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenname = true;

				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenname) {
					qPos.add(screenname);
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

	private static final String _FINDER_COLUMN_SCREENNAME_SCREENNAME_1 = "purchase.id.screenname IS NULL";
	private static final String _FINDER_COLUMN_SCREENNAME_SCREENNAME_2 = "purchase.id.screenname = ?";
	private static final String _FINDER_COLUMN_SCREENNAME_SCREENNAME_3 = "(purchase.id.screenname IS NULL OR purchase.id.screenname = '')";

	public PurchasePersistenceImpl() {
		setModelClass(Purchase.class);
	}

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	@Override
	public void cacheResult(Purchase purchase) {
		entityCache.putResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseImpl.class, purchase.getPrimaryKey(), purchase);

		purchase.resetOriginalValues();
	}

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	@Override
	public void cacheResult(List<Purchase> purchases) {
		for (Purchase purchase : purchases) {
			if (entityCache.getResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseImpl.class, purchase.getPrimaryKey()) == null) {
				cacheResult(purchase);
			}
			else {
				purchase.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all purchases.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PurchaseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Purchase purchase) {
		entityCache.removeResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseImpl.class, purchase.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Purchase> purchases) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Purchase purchase : purchases) {
			entityCache.removeResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseImpl.class, purchase.getPrimaryKey());
		}
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchasePK the primary key for the new purchase
	 * @return the new purchase
	 */
	@Override
	public Purchase create(PurchasePK purchasePK) {
		Purchase purchase = new PurchaseImpl();

		purchase.setNew(true);
		purchase.setPrimaryKey(purchasePK);

		String uuid = PortalUUIDUtil.generate();

		purchase.setUuid(uuid);

		return purchase;
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchasePK the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(PurchasePK purchasePK)
		throws NoSuchPurchaseException {
		return remove((Serializable)purchasePK);
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(Serializable primaryKey)
		throws NoSuchPurchaseException {
		Session session = null;

		try {
			session = openSession();

			Purchase purchase = (Purchase)session.get(PurchaseImpl.class,
					primaryKey);

			if (purchase == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(purchase);
		}
		catch (NoSuchPurchaseException nsee) {
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
	protected Purchase removeImpl(Purchase purchase) {
		purchase = toUnwrappedModel(purchase);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchase)) {
				purchase = (Purchase)session.get(PurchaseImpl.class,
						purchase.getPrimaryKeyObj());
			}

			if (purchase != null) {
				session.delete(purchase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (purchase != null) {
			clearCache(purchase);
		}

		return purchase;
	}

	@Override
	public Purchase updateImpl(Purchase purchase) {
		purchase = toUnwrappedModel(purchase);

		boolean isNew = purchase.isNew();

		PurchaseModelImpl purchaseModelImpl = (PurchaseModelImpl)purchase;

		if (Validator.isNull(purchase.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			purchase.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (purchase.isNew()) {
				session.save(purchase);

				purchase.setNew(false);
			}
			else {
				purchase = (Purchase)session.merge(purchase);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PurchaseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((purchaseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { purchaseModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { purchaseModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((purchaseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						purchaseModelImpl.getOriginalScreenname()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENNAME,
					args);

				args = new Object[] { purchaseModelImpl.getScreenname() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREENNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREENNAME,
					args);
			}
		}

		entityCache.putResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseImpl.class, purchase.getPrimaryKey(), purchase, false);

		purchase.resetOriginalValues();

		return purchase;
	}

	protected Purchase toUnwrappedModel(Purchase purchase) {
		if (purchase instanceof PurchaseImpl) {
			return purchase;
		}

		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setNew(purchase.isNew());
		purchaseImpl.setPrimaryKey(purchase.getPrimaryKey());

		purchaseImpl.setUuid(purchase.getUuid());
		purchaseImpl.setScreenname(purchase.getScreenname());
		purchaseImpl.setHash(purchase.getHash());
		purchaseImpl.setDate_time(purchase.getDate_time());
		purchaseImpl.setCurr_from(purchase.getCurr_from());
		purchaseImpl.setValue_from(purchase.getValue_from());
		purchaseImpl.setCurr_to(purchase.getCurr_to());
		purchaseImpl.setValue_to(purchase.getValue_to());
		purchaseImpl.setStatus(purchase.getStatus());
		purchaseImpl.setEwallet(purchase.getEwallet());

		return purchaseImpl;
	}

	/**
	 * Returns the purchase with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseException {
		Purchase purchase = fetchByPrimaryKey(primaryKey);

		if (purchase == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or throws a {@link NoSuchPurchaseException} if it could not be found.
	 *
	 * @param purchasePK the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(PurchasePK purchasePK)
		throws NoSuchPurchaseException {
		return findByPrimaryKey((Serializable)purchasePK);
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Purchase purchase = (Purchase)serializable;

		if (purchase == null) {
			Session session = null;

			try {
				session = openSession();

				purchase = (Purchase)session.get(PurchaseImpl.class, primaryKey);

				if (purchase != null) {
					cacheResult(purchase);
				}
				else {
					entityCache.putResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PurchaseModelImpl.ENTITY_CACHE_ENABLED,
					PurchaseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchasePK the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase fetchByPrimaryKey(PurchasePK purchasePK) {
		return fetchByPrimaryKey((Serializable)purchasePK);
	}

	@Override
	public Map<Serializable, Purchase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Purchase> map = new HashMap<Serializable, Purchase>();

		for (Serializable primaryKey : primaryKeys) {
			Purchase purchase = fetchByPrimaryKey(primaryKey);

			if (purchase != null) {
				map.put(primaryKey, purchase);
			}
		}

		return map;
	}

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	@Override
	public List<Purchase> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	@Override
	public List<Purchase> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(int start, int end,
		OrderByComparator<Purchase> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PurchaseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean retrieveFromCache) {
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

		List<Purchase> list = null;

		if (retrieveFromCache) {
			list = (List<Purchase>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PURCHASE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASE;

				if (pagination) {
					sql = sql.concat(PurchaseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Purchase>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the purchases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Purchase purchase : findAll()) {
			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PURCHASE);

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
		return PurchaseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the purchase persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PurchaseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PURCHASE = "SELECT purchase FROM Purchase purchase";
	private static final String _SQL_SELECT_PURCHASE_WHERE = "SELECT purchase FROM Purchase purchase WHERE ";
	private static final String _SQL_COUNT_PURCHASE = "SELECT COUNT(purchase) FROM Purchase purchase";
	private static final String _SQL_COUNT_PURCHASE_WHERE = "SELECT COUNT(purchase) FROM Purchase purchase WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "purchase.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Purchase exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Purchase exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PurchasePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}