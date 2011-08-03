package com.capgemini.capservice.scrumboard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;
import com.capgemini.persistence.dao.ScrumBoardDao;

/**
 * Unit test for the ScrumBoardServiceImpl class.
 * @author Henrik Hahne (Capgemini)
 * @author Sanjin Cevro (Capgemini)
 *
 */
public class ScrumBoardServiceTest {
	
	@Mock
	private ScrumBoardDao scrumBoardDao;
	
	private ScrumBoardService service;
//	ScrumNote aNote;
//	ScrumNote aNote2;
//	ScrumNote aNote3;
//	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new ScrumBoardServiceImpl(scrumBoardDao);
//		aNote = createNote(Long.valueOf(1), "Headline 1", "Dette er en test", 10);
//		aNote2 = createNote(Long.valueOf(2), "Headline 2", "Dette er en test", 11);
//		aNote3 = createNote(Long.valueOf(3), "Headline 3", "Dette er en test", 12);
	}
//
//	/**
//	 * Tests that a ScrumNote can be created successfully.
//	 */
//	@Test
//	public void testCreateNotStartedScrumNote() {
//		ScrumBoard board = service.createNotStartedScrumNote(aNote);
//		assertNotNull(board);
//		assertNotNull(board.getNotStartedList());
//		assertEquals(1, board.getNotStartedList().size());
//		assertEquals("Headline 1", board.getNotStartedList().get(0).getHeadline());
//	}
//	
//	
//	/**
//	 * Tests that a ScrumNote can be moved from the not started part of the board to the In progress part.
//	 */
//	@Test
//	public void testMoveFromNotStartedToInProgress() {
//		ScrumBoard board = service.createNotStartedScrumNote(aNote);
//		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
//		assertNotNull(board);
//		assertEquals(0, board.getNotStartedList().size());
//		assertEquals(1, board.getInProgressList().size());
//	}
//	
//	/**
//	 * Tests that a ScrumNote can be moved from the in progress part to the done part.
//	 */
//	@Test
//	public void testMoveFromInProgressToDone() {
//		ScrumBoard board = service.createNotStartedScrumNote(aNote);
//		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
//		board = service.moveFromInProgressToDone(Long.valueOf(1));
//		assertNotNull(board);
//		assertEquals(0, board.getNotStartedList().size());
//		assertEquals(0, board.getInProgressList().size());
//		assertEquals(1, board.getDoneList().size());
//	}
//	
//	/**
//	 * Tests that a ScrumNote can be moved from the in progress part to the not started part.
//	 */
//	@Test
//	public void testMoveFromInprogressToNotStarted() {
//		ScrumBoard board = service.createNotStartedScrumNote(aNote);
//		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
//		board = service.moveFromInProgressToNotStarted(Long.valueOf(1));
//		assertEquals(1, board.getNotStartedList().size());
//		assertEquals(0, board.getInProgressList().size());
//	}
//	
//	/**
//	 * Tests that a ScrumNote can be moved from the done part to the in progress part.
//	 */
//	@Test
//	public void testMoveFromDoneToInProgress() {
//		ScrumBoard board = service.createNotStartedScrumNote(aNote);
//		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
//		board = service.moveFromInProgressToDone(Long.valueOf(1));
//		board = service.moveFromDoneToInProgress(Long.valueOf(1));
//		assertEquals(0, board.getNotStartedList().size());
//		assertEquals(1, board.getInProgressList().size());
//		assertEquals(0, board.getDoneList().size());
//	}
//	
	/**
	 * Helper method to create a ScrumNote.
	 * @param noteId the Id to use, note that this would normally be given by the ORM framework (typically Hibernate)
	 * @param headline the headline of the note
	 * @param description the description of the note
	 * @param estimate the estimate of the wortkload of the task.
	 * @return a newly created scrumNote.
	 */
	private ScrumNote createNote(Long noteId, String headline, String description, Integer estimate) {
		ScrumNote aNote = new ScrumNote();
		aNote.setNoteId(noteId);
		aNote.setHeadline(headline);
		aNote.setDescription(description);
		aNote.setEstimate(estimate);
		return aNote;
	}
}
