package com.capgemini.capservice.scrumboard;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumNote;
import com.capgemini.persistence.dao.ScrumNoteDao;

/**
 * Unit test for the ScrumNoteServiceImpl class.
 * 
 * @author Henrik Hahne (Capgemini)
 * @author Sanjin Cevro (Capgemini)
 * 
 */
public class ScrumNoteServiceTest {

	@Mock
	private ScrumNoteDao scrumNoteDao;

	private ScrumNoteService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new ScrumNoteServiceImpl(scrumNoteDao);
	}

	/**
	 * Tests that a ScrumNotes can be retrieved successfully by using a specific state.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void retrieveNotesByState() {
		List<ScrumNote> notes = createMockedScrumNotes(NoteState.NOT_STARTED);
		
		when(scrumNoteDao.findByNamedQuery(anyString(), anyMap())).thenReturn(notes);
		
		List<ScrumNote> returnedList = service.getScrumNotesByState(NoteState.NOT_STARTED);
		
		assertNotNull(returnedList);
		assertFalse(returnedList.isEmpty());
		assertEquals(2, returnedList.size());
		
	}

	private List<ScrumNote> createMockedScrumNotes(NoteState state){
		List<ScrumNote> notes = new ArrayList<ScrumNote>();
		ScrumNote aNote = createNote(Long.valueOf(1), "Headline 1", "Dette er en test", 10, state);
		ScrumNote anotherNote = createNote(Long.valueOf(2), "Headline 2", "Dette er en test", 11, state);

		notes.add(aNote);
		notes.add(anotherNote);
		
		return notes;
	}
	/**
	 * Helper method to create a ScrumNote.
	 * 
	 * @param noteId
	 *            the Id to use, note that this would normally be given by the ORM framework (typically Hibernate)
	 * @param headline
	 *            the headline of the note
	 * @param description
	 *            the description of the note
	 * @param estimate
	 *            the estimate of the wortkload of the task.
	 * @param state
	 *            A state for note. Enumerated value from {@link NoteState}
	 * @return a newly created scrumNote.
	 */
	private ScrumNote createNote(Long noteId, String headline, String description, Integer estimate, NoteState state) {
		ScrumNote aNote = new ScrumNote();
		aNote.setNoteId(noteId);
		aNote.setHeadline(headline);
		aNote.setDescription(description);
		aNote.setEstimate(estimate);
		aNote.setState(state);
		return aNote;
	}
}
