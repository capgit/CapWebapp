package com.capgemini.scrumboard;

import java.util.ArrayList;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;
import com.capgemini.capservice.scrumboard.ScrumBoardService;

/**
 * Action delegate handling all coomunication to and from the service layer. 
 * @author Henrik Hahne (Capgemini)
 *
 */
public class ScrumBoardActionDelegate {

	private ScrumBoardService service;
	
	public ScrumBoard createNewScrumNote(ScrumNote aNewNote) {		
		//TODO: Make sure the service actually persists the object.
		return service.createNotStartedScrumNote(aNewNote);
	}

	/**
	 * @return the service
	 */
	public ScrumBoardService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(ScrumBoardService service) {
		this.service = service;
	}

	/**
	 * Gets the newest scrumboard from the service.
	 * @return a new and fresh scrumboard.
	 */
	public ScrumBoard getNewestScrumboard() {
		return service.getScrumBoard();
	}
	
	/**
	 * Creates an empty scrum board.
	 * @return a newly created scrum board.
	 */
	public ScrumBoard createEmptyScrumBoard() {
		//TODO: This is a job for the service perhaps ? 
		ScrumBoard board = new ScrumBoard();
		board.setNotStartedList(new ArrayList<ScrumNote>());
		board.setInProgressList(new ArrayList<ScrumNote>());
		board.setDoneList(new ArrayList<ScrumNote>());
		return board;
	}
}
