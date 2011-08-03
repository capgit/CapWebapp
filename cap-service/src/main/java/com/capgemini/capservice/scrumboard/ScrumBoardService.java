package com.capgemini.capservice.scrumboard;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

/**
 * Simple interface to manage the scrum board.
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 *
 */
public interface ScrumBoardService extends GenericService<ScrumBoard, Long>{

	/**
	 * Makes a new note to put onto the ssrum board in the "Not started" column.
	 * @param aNote the note to add.
	 * @return the updated ScrumBoard
	 */
	public abstract ScrumBoard createNotStartedScrumNote(ScrumNote aNote);
	
}
