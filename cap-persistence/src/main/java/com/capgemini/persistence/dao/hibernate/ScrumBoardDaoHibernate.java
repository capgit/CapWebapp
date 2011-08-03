package com.capgemini.persistence.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.persistence.dao.ScrumBoardDao;

/**
 * @author Sanjin Cevro (Capgemini)
 * 
 */
@Repository("scrumBoardDao")
public class ScrumBoardDaoHibernate extends GenericDaoHibernate<ScrumBoard, Long> implements ScrumBoardDao {

	public ScrumBoardDaoHibernate() {
		super(ScrumBoard.class);
	}

}
