package com.capgemini.capservice.scrumboard;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;

/**
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 *
 */
@ContextConfiguration("/service-config.xml")
public class ScrumBoardserviceITest extends AbstractJUnit4SpringContextTests{

	private ScrumBoardService service;
	private ScrumNote aNote;

	@Before
	public void setUp() {
		service = applicationContext.getBean(ScrumBoardService.class);
		aNote = createNote(Long.valueOf(1), "Headline 1", "Dette er en test", 10);
	}

	@Test
	public void testConfigSetup(){
		assertNotNull(service);
	}
	
	@Test
	public void testMoveFromNotStartedToInProgress(){
		ScrumBoard board = service.createNotStartedScrumNote(aNote);
		board = service.moveFromNotStartedToInProgress(Long.valueOf(1));
		assertNotNull(board);
		assertEquals(0, board.getNotStartedList().size());
		assertEquals(1, board.getInProgressList().size());
		
	}
	
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
