package com.capgemini.capservice.scrumboard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;


public class ScrumBoardServiceTest {
	ScrumBoardService service;
	ScrumNote aNote;
	ScrumNote aNote2;
	ScrumNote aNote3;
	
	@Before
	public void setUp() {
		service = new ScrumBoardServiceImpl();
		aNote = createNote(Long.valueOf(1), "Headline 1", "Dette er en test", 10);
		aNote2 = createNote(Long.valueOf(2), "Headline 2", "Dette er en test", 11);
		aNote3 = createNote(Long.valueOf(3), "Headline 3", "Dette er en test", 12);
	}

	@Test
	public void testCreateNotStartedScrumNote() {
		ScrumBoard board = service.createNotStartedScrumNote(aNote);
		assertNotNull(board);
		assertNotNull(board.getNotStartedList());
		assertEquals(1, board.getNotStartedList().size());
		assertEquals("Headline 1", board.getNotStartedList().get(0).getHeadline());
	}
	
	
	@Test
	public void testMoveFromNotStartedToInProgress() {
		ScrumBoard board = service.createNotStartedScrumNote(aNote);
		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
		assertNotNull(board);
		assertNotNull(board.getInProgressList());
		assertEquals(1, board.getInProgressList().size());
		assertEquals(0, board.getNotStartedList().size());
	}
	
	private ScrumNote createNote(Long noteId, String headline, String description, Integer estimate) {
		ScrumNote aNote = new ScrumNote();
		aNote.setNoteId(noteId);
		aNote.setHeadline(headline);
		aNote.setDescription(description);
		aNote.setEstimate(estimate);
		return aNote;
	}
}
