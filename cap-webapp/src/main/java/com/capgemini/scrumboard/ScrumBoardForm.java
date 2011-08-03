package com.capgemini.scrumboard;

import java.io.Serializable;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

public class ScrumBoardForm implements Serializable {

	private static final long serialVersionUID = 4335179057399237721L;
	
	private ScrumNote newNote = new ScrumNote();
	private ScrumBoard board;
	
	/**
	 * @return the board
	 */
	public ScrumBoard getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(ScrumBoard board) {
		this.board = board;
	}

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
		newNote = new ScrumNote();
	}

}
