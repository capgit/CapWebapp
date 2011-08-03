package com.capgemini.capservice.scrumboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.core.NoteState;
import com.capgemini.core.dao.GenericDao;
import com.capgemini.core.domain.ScrumNote;

/**
 * @author Sanjin Cevro (Capgemini)
 *
 */
public class ScrumNoteServiceImpl extends GenericServiceImpl<ScrumNote, Long> implements ScrumNoteService{

	public ScrumNoteServiceImpl(GenericDao<ScrumNote, Long> genericDao) {
		super(genericDao);

	}

	@Override
	public List<ScrumNote> getScrumNotesByState(NoteState state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);
		
		return genericDao.findByNamedQuery("scrumNote.getNotesByState", params);
	}

}
