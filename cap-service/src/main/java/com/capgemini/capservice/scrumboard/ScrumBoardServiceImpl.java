package com.capgemini.capservice.scrumboard;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;

@Service
public class ScrumBoardServiceImpl implements ScrumBoardService {
	private ScrumBoard scrumBoard;
	
	public ScrumBoardServiceImpl() {
		scrumBoard = new ScrumBoard();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard moveFromNotStartedToInProgress(Long noteId) {
		ScrumNote result = findScrumNoteInList(noteId, scrumBoard.getNotStartedList());
		moveFromListAToB(result, scrumBoard.getNotStartedList(), scrumBoard.getInProgressList());
		return scrumBoard;
	}

	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard moveFromInProgressToDone(Long noteId) {
		ScrumNote result = findScrumNoteInList(noteId, scrumBoard.getInProgressList());
		moveFromListAToB(result, scrumBoard.getInProgressList(), scrumBoard.getDoneList());
		return scrumBoard;	
	}

	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard moveFromInProgressToNotStarted(Long noteId) {
		ScrumNote result = findScrumNoteInList(noteId, scrumBoard.getInProgressList());
		moveFromListAToB(result, scrumBoard.getInProgressList(), scrumBoard.getNotStartedList());
		return scrumBoard;	
	}

	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard moveFromDoneToInProgress(Long noteId) {
		ScrumNote result = findScrumNoteInList(noteId, scrumBoard.getDoneList());
		moveFromListAToB(result, scrumBoard.getDoneList(), scrumBoard.getInProgressList());
		return scrumBoard;
	}

	/**
	 * {@inheritDoc}
	 */
	public ScrumBoard createNotStartedScrumNote(ScrumNote aNote) {
		scrumBoard.getNotStartedList().add(aNote);
		return scrumBoard;
	}
	
	private ScrumNote findScrumNoteInList(Long noteId, List<ScrumNote> list) {
		ScrumNote result = null;
		for (ScrumNote scrumNote : list) {
			if(scrumNote.getNoteId().equals(noteId)) {
				result = scrumNote;
			}
		}
		return result;
	}
	
	/**
	 * Move a scrumNote from the source list to the destination list. 
	 * @param noteToMove the note to move.	
	 * @param source the source list.
	 * @param destination the destination list.
	 */
	private void moveFromListAToB(ScrumNote noteToMove, List<ScrumNote> source, List<ScrumNote> destination) {
		if(noteToMove != null) {
			source.remove(noteToMove);
			destination.add(noteToMove);
		}
	}

	/**
	 * @return the scrumBoard
	 */
	public ScrumBoard getScrumBoard() {
		return scrumBoard;
	}

	
	
	
}
