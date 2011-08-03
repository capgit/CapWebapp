package com.capgemini.persistence.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

/**
 * @author Sanjin Cevro (Capgemini)
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistence-config.xml")
public class ScrumNoteDaoTest {

	protected final Logger LOG = LoggerFactory.getLogger(getClass());

	@Resource
	private ScrumNoteDao scrumNoteDao;

	@Resource
	private ScrumBoardDao scrumBoardDao;

	@Test
	public void checkScrumNoteCRUD() {

		ScrumBoard scrumBoard = scrumBoardDao.save(new ScrumBoard());
		ScrumNote note = createScrumNote("test", "Description", 20, NoteState.IN_PROGRESS, scrumBoard);

		note = scrumNoteDao.save(note);
		assertNotNull(note.getNoteId());
		assertEquals("test", note.getHeadline());

		note.setEstimate(15);
		note = scrumNoteDao.save(note);
		assertEquals(15, note.getEstimate().intValue());

		LOG.info("Number of scrumNotes = " + scrumNoteDao.getAll().size());

		scrumNoteDao.remove(note.getNoteId());
		assertEquals(0, scrumNoteDao.getAll().size());
	}
	
	@Test
	public void testRetrievalByState(){
		ScrumBoard scrumBoard = scrumBoardDao.save(new ScrumBoard());
		ScrumNote note = createScrumNote("test", "Description", 20, NoteState.NOT_STARTED, scrumBoard);
		scrumNoteDao.save(note);
		ScrumNote note2 = createScrumNote("test2", "Description2", 30, NoteState.IN_PROGRESS, scrumBoard);
		scrumNoteDao.save(note2);
		ScrumNote note3 = createScrumNote("test3", "Description3", 40, NoteState.NOT_STARTED, scrumBoard);
		scrumNoteDao.save(note3);
		ScrumNote note4 = createScrumNote("test4", "Description4", 40, NoteState.DONE, scrumBoard);
		scrumNoteDao.save(note4);
		ScrumNote note5 = createScrumNote("test5", "Description5", 40, NoteState.DONE, scrumBoard);
		scrumNoteDao.save(note5);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", NoteState.NOT_STARTED);
		List<ScrumNote> notStartedList = scrumNoteDao.findByNamedQuery("scrumNote.getNotesByState", params);
		assertEquals(2, notStartedList.size());
		
		params.clear();
		params.put("state", NoteState.IN_PROGRESS);
		List<ScrumNote> inProgressList = scrumNoteDao.findByNamedQuery("scrumNote.getNotesByState", params);
		assertEquals(1, inProgressList.size());
		
		params.clear();
		params.put("state", NoteState.DONE);
		List<ScrumNote> doneList = scrumNoteDao.findByNamedQuery("scrumNote.getNotesByState", params);
		assertEquals(2, doneList.size());
	}

	/**
	 * Helper method for ScrumNote creation.
	 * 
	 * @param headline
	 * @param description
	 * @param estimate
	 * @param state
	 * @param board
	 * @return
	 */
	private ScrumNote createScrumNote(String headline, String description, Integer estimate, NoteState state, ScrumBoard board) {

		ScrumNote note = new ScrumNote();
		note.setHeadline(headline);
		note.setEstimate(estimate);
		note.setDescription(description);
		note.setScrumBoard(board);
		note.setState(state);

		return note;

	}
}
