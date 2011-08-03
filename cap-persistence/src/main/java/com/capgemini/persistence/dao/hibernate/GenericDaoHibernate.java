package com.capgemini.persistence.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.capgemini.core.dao.GenericDao;


public class GenericDaoHibernate<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {
	/**
	 * Log variable for all child classes.
	 */
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private Class<T> type;

	/**
	 * Constructor that takes in a class to see which type of entity to persist
	 * 
	 * @param type
	 *            the class type you'd like to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		this.type = persistentClass;
	}

	@Autowired
	public void doSessionStuff(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll() {
		return super.getHibernateTemplate().loadAll(this.type);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);
	}

	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		T entity = (T) super.getHibernateTemplate().get(this.type, id);

		if (entity == null) {
			log.warn("Uh oh, '" + this.type + "' object with id '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(this.type, id);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		T entity = (T) super.getHibernateTemplate().get(this.type, id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public T save(T object) {
		return (T) super.getHibernateTemplate().merge(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		super.getHibernateTemplate().delete(this.get(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		String[] params = new String[queryParams.size()];
		Object[] values = new Object[queryParams.size()];
		int index = 0;
		Iterator<String> i = queryParams.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			params[index] = key;
			values[index++] = queryParams.get(key);
		}
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, params, values);
	}

}
