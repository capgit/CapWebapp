package com.capgemini.scrumboard;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.capcore.scrumboard.ScrumNote;
import com.capgemini.capservice.scrumboard.ScrumBoardService;

/**
 * Action delegate handling all coomunication to and from the service layer. 
 * @author Henrik Hahne (Capgemini)
 *
 */
public class ScrumBoardActionDelegate {

	private ScrumBoardService service;
	
	public ScrumNote createNewScrumNote(ScrumNote aNewNote) {
		
		//TODO: Make sure the service actually persists the object.
		return aNewNote;
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
	
}
