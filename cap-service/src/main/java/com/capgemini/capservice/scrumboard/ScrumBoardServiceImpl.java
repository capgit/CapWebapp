package com.capgemini.capservice.scrumboard;

import java.util.List;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;
import com.capgemini.persistence.dao.ScrumBoardDao;

public class ScrumBoardServiceImpl extends GenericServiceImpl<ScrumBoard, Long> implements ScrumBoardService {

	private ScrumBoardDao scrumBoardDao;

	public ScrumBoardServiceImpl(ScrumBoardDao scrumBoardDao) {
		super(scrumBoardDao);
		this.scrumBoardDao = scrumBoardDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard createNotStartedScrumNote(ScrumNote aNote) {
//		scrumBoard.getNotStartedList().add(aNote);
		return null;
	}	
}
