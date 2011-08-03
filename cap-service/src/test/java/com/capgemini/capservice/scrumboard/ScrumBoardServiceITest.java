package com.capgemini.capservice.scrumboard;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

/**
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 * 
 */
@ContextConfiguration("/service-config.xml")
public class ScrumBoardServiceITest extends AbstractJUnit4SpringContextTests {

	private ScrumBoardService scrumBoardService;
	private ScrumNoteService scrumNoteService;

	@Before
	public void setUp() {
		scrumBoardService = (ScrumBoardService) applicationContext.getBean("scrumBoardService");
		scrumNoteService = (ScrumNoteService) applicationContext.getBean("scrumNoteService");
	}

	@Test
	public void testConfigSetup() {
		assertNotNull(scrumBoardService);
	}

	@Test
	public void checkScrumNoteandScrumBoardCRUD() {
		ScrumBoard scrumBoard = scrumBoardService.save(new ScrumBoard());

		ScrumNote note = createNote("test", "Description", 20, NoteState.NOT_STARTED, scrumBoard);

		note = scrumNoteService.save(note);
		assertNotNull(note.getNoteId());

		note.setEstimate(15);
		note = scrumNoteService.save(note);
		assertEquals(15, note.getEstimate().intValue());

		scrumNoteService.remove(note.getNoteId());
		assertEquals(0, scrumNoteService.getAll().size());

	}

	@Test
	public void testRetrievalByState() {
		ScrumBoard scrumBoard = scrumBoardService.save(new ScrumBoard());
		
		List<ScrumNote> noteList = new ArrayList<ScrumNote>();
		noteList.addAll(createScrumNoteList(NoteState.IN_PROGRESS, scrumBoard));
		noteList.addAll(createScrumNoteList(NoteState.DONE, scrumBoard));
		for (ScrumNote scrumNote : noteList) {
			scrumNoteService.save(scrumNote);
		}
		
		assertEquals(3, scrumNoteService.getScrumNotesByState(NoteState.IN_PROGRESS).size());
		assertEquals(3, scrumNoteService.getScrumNotesByState(NoteState.DONE).size());
		
	}

	private List<ScrumNote> createScrumNoteList(NoteState state, ScrumBoard scrumBoard) {
		ArrayList<ScrumNote> noteList = new ArrayList<ScrumNote>();
		noteList.add(createNote("test", "desc", 20, state, scrumBoard));
		noteList.add(createNote("test2", "desc2", 25, state, scrumBoard));
		noteList.add(createNote("test3", "desc3", 10, state, scrumBoard));

		return noteList;
	}

	/**
	 * Helper method to create a ScrumNote.
	 * 
	 * @param headline
	 *            the headline of the note
	 * @param description
	 *            the description of the note
	 * @param estimate
	 *            the estimate of the workload of the task.
	 * @param state
	 *            State for the new note.
	 * @return a newly created scrumNote.
	 */
	private ScrumNote createNote(String headline, String description, Integer estimate, NoteState state, ScrumBoard scrumBoard) {
		ScrumNote aNote = new ScrumNote();
		aNote.setHeadline(headline);
		aNote.setDescription(description);
		aNote.setEstimate(estimate);
		aNote.setState(state);
		aNote.setScrumBoard(scrumBoard);
		return aNote;
	}

}
