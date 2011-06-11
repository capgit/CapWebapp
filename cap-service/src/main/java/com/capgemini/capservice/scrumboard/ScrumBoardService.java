package com.capgemini.capservice.scrumboard;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;

/**
 * Simple interface to manage the scrum board.
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 *
 */
public interface ScrumBoardService {
	/**
	 * Moves a ScrumNote from the Not started column to In Progress
	 * @param noteId the Id of the note to Move.
	 */
	public abstract ScrumBoard moveFromNotStartedToInProgress(Long noteId);

	/**
	 * Moves a ScrumNote from the In Progress to Done
	 * @param noteId the Id of the note to Move.
	 */
	public abstract ScrumBoard moveFromInProgressToDone(Long noteId);
	
	/**
	 * Moves a ScrumNote from the In Progress column to Not Started.
	 * @param noteId the Id of the note to Move.
	 */
	public abstract ScrumBoard moveFromInProgressToNotStarted(Long noteId);
	
	/**
	 * Moves a ScrumNote from the Done column to In Progress
	 * @param noteId the Id of the note to Move.
	 */
	public abstract ScrumBoard moveFromDoneToInProgress(Long noteId);
	
	/**
	 * Makes a new note to put onto the ssrum board in the "Not started" column.
	 * @param aNote the note to add.
	 * @return the updated ScrumBoard
	 */
	public abstract ScrumBoard createNotStartedScrumNote(ScrumNote aNote);
	
	/**
	 * Gets the scrumBoard you are working on. 
	 * @return a scrumBoard.
	 */
	public abstract ScrumBoard getScrumBoard();
	
}
