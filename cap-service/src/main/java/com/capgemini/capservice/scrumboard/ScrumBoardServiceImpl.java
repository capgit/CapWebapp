package com.capgemini.capservice.scrumboard;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.persistence.dao.ScrumBoardDao;

/**
 * 
 * @author Sanjin Cevro (Capgemini)
 *
 */
public class ScrumBoardServiceImpl extends GenericServiceImpl<ScrumBoard, Long> implements ScrumBoardService {

	public ScrumBoardServiceImpl(ScrumBoardDao scrumBoardDao) {
		super(scrumBoardDao);
	}

}
