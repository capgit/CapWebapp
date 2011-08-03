package com.capgemini.capservice.scrumboard;

import java.util.List;

import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumNote;

/**
 * @author Sanjin Cevro (Capgemini)
 * 
 */
public interface ScrumNoteService extends GenericService<ScrumNote, Long> {

	/**
	 * Retreives a list of ScrumNotes with given specific state.
	 * 
	 * @param state
	 *            Notestate
	 * @return a List of notes
	 */
	List<ScrumNote> getScrumNotesByState(NoteState state);

}
