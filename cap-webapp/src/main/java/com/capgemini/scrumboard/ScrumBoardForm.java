package com.capgemini.scrumboard;

import com.capgemini.capcore.scrumboard.ScrumNote;

public class ScrumBoardForm {
	ScrumNote newNote;

	/**
	 * @return the newNote
	 */
	public ScrumNote getNewNote() {
		return newNote;
	}

	/**
	 * @param newNote the newNote to set
	 */
	public void setNewNote(ScrumNote newNote) {
		this.newNote = newNote;
	}

	/**
	 * Resets all the variables in the form object. 
	 */
	public void reset() {
		newNote = null;
	}
	
	


}
