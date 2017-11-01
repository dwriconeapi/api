package org.ricone.api.dao;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.query.Query;
import org.ricone.api.cache.CacheContainer;
import org.ricone.api.controller.extension.MetaData;
import org.ricone.api.exception.NoContentException;
import org.ricone.api.model.core.EventLog;
import org.ricone.api.model.core.extension.event.EventObject;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

@Repository("changesSinceDAO")
public class EventLogDAO extends AbstractDAO<Integer, EventLog> implements IEventLogDAO
{
	private final String OBJECT = "object";
	private final String EVENT_TIME_STAMP = "eventTimestamp";

	private final CacheContainer cacheContainer = new CacheContainer();

	@Override
	public List<EventLog> findAllByLea(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
					cb.equal(from.get(OBJECT), EventObject.LEA),
					cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllBySchool(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.SCHOOL),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllByCalendar(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.CALENDAR),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllByCourse(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.COURSE),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}



	@Override
	public List<EventLog> findAllByRoster(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.ROSTER),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllByStaff(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.STAFF),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllByStudent(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.STUDENT),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}

	@Override
	public List<EventLog> findAllByContact(MetaData metaData, LocalDateTime iso8601) throws Exception {
		final CriteriaBuilder cb = getSession().getCriteriaBuilder();
		final CriteriaQuery<EventLog> select = cb.createQuery(EventLog.class);
		final Root<EventLog> from = select.from(EventLog.class);

		select.distinct(true);
		select.select(from);
		select.where
		(
			cb.and
			(
				cb.equal(from.get(OBJECT), EventObject.CONTACT),
				cb.greaterThanOrEqualTo(from.get(EVENT_TIME_STAMP), iso8601)
			)
		);
		select.orderBy(cb.asc(from.get(EVENT_TIME_STAMP)));

		Query<EventLog> q = getSession().createQuery(select);
		if(metaData.getPaging().isPaged()){
			q.setFirstResult(metaData.getPaging().getPageNumber() * metaData.getPaging().getPageSize());
			q.setMaxResults(metaData.getPaging().getPageSize());
		}
		List<EventLog> instance = q.getResultList();

		if(CollectionUtils.isEmpty(instance)) throw new NoContentException();
		return instance;
	}
}
