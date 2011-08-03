package com.capgemini.scrumboard;

import java.util.List;

import com.capgemini.capservice.scrumboard.ScrumBoardService;
import com.capgemini.capservice.scrumboard.ScrumNoteService;
import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

/**
 * Action delegate handling all communication to and from the scrumBoardService layer.
 * 
 * @author Henrik Hahne (Capgemini)
 * @author Sanjin Cevro (Capgemini)
 */
public class ScrumBoardActionDelegate {

	private ScrumBoardService scrumBoardService;
	private ScrumNoteService scrumNoteService;

	/**
	 * Moves a ScrumNote from the Not started column to In Progress
	 * 
	 * @param noteId
	 *            the Id of the note to Move.
	 */
	public void moveToInProgress(Long noteId) {
		updateNoteState(noteId, NoteState.IN_PROGRESS);
	}

	/**
	 * Moves a ScrumNote to Not Started.
	 * 
	 * @param noteId
	 *            the Id of the note to Move.
	 */
	public void moveToNotStarted(Long noteId) {
		updateNoteState(noteId, NoteState.NOT_STARTED);
	}

	/**
	 * Moves a ScrumNote to Done
	 * 
	 * @param noteId
	 *            the Id of the note to Move.
	 */
	public void moveToDone(Long noteId) {
		updateNoteState(noteId, NoteState.DONE);
	}

	public ScrumNote createNewScrumNote(ScrumNote aNewNote) {
		return scrumNoteService.save(aNewNote);
	}

	/**
	 * Gets the newest scrumboard from the scrumBoardService.
	 * 
	 * @return a new and fresh scrumboard.
	 */
	public ScrumBoard getNewestScrumboard() {
		List<ScrumBoard> scrumBoardList = scrumBoardService.getAll();
		if (scrumBoardList != null && !scrumBoardList.isEmpty()) {
			return scrumBoardList.get(0);
		}
		return createEmptyScrumBoard();
	}

	public List<ScrumNote> getScrumNotesByState(NoteState state) {
		return scrumNoteService.getScrumNotesByState(state);
	}

	/**
	 * @param scrumBoardService
	 *            the scrumBoardService to set
	 */
	public void setScrumBoardService(ScrumBoardService scrumBoardService) {
		this.scrumBoardService = scrumBoardService;
	}

	/**
	 * @param scrumNoteService
	 *            the scrumNoteService to set
	 */
	public void setScrumNoteService(ScrumNoteService scrumNoteService) {
		this.scrumNoteService = scrumNoteService;
	}

	/**
	 * Creates an empty scrum board.
	 * 
	 * @return a newly created scrum board.
	 */
	private ScrumBoard createEmptyScrumBoard() {
		ScrumBoard scrumBoard = new ScrumBoard();
		return scrumBoardService.save(scrumBoard);
	}

	private void updateNoteState(Long noteId, NoteState newState) {
		ScrumNote note = scrumNoteService.get(noteId);
		if (note != null) {
			note.setState(newState);
			scrumNoteService.save(note);
		}
	}
}
