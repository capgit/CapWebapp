package com.capgemini.persistence.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.capgemini.core.domain.ScrumNote;
import com.capgemini.persistence.dao.ScrumNoteDao;

/**
 * @author Sanjin Cevro (Capgemini)
 * 
 */
@Repository("scrumNoteDao")
public class ScrumNoteDaoHibernate extends GenericDaoHibernate<ScrumNote, Long> implements
		ScrumNoteDao {

	public ScrumNoteDaoHibernate() {
		super(ScrumNote.class);
	}

}
