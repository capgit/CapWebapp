package com.capgemini.scrumboard;

import java.util.List;

import org.richfaces.event.DropEvent;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.capgemini.core.NoteState;
import com.capgemini.core.domain.ScrumBoard;
import com.capgemini.core.domain.ScrumNote;

/**
 * Main action class for the scrum board webapp.
 * 
 * @author Henrik Hahne (Capgemini)
 * @author Sanjin Cevro (Capgemini)
 * 
 */
// TODO: Validation !
public class ScrumBoardAction extends FormAction {

	private ScrumBoard scrumBoard;

	public ScrumBoardActionDelegate actionDelegate;

	private List<ScrumNote> notStartedList;
	private List<ScrumNote> inProgressList;
	private List<ScrumNote> doneList;
	/**
	 * @see org.springframework.webflow.action.FormAction#createFormObject(org.
	 *      springframework.webflow.execution.RequestContext)
	 */
	@Override
	protected Object createFormObject(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		form.setNewNote(new ScrumNote());
		form.setBoard(actionDelegate.getNewestScrumboard());

		scrumBoard = form.getBoard();

		updateNoteLists();
		
		return super.createFormObject(context);

	}

	/**
	 * This method should be called when the user presses the "create note" button.
	 * 
	 * @param context
	 *            the context containing the form with the new ScrumNote to create
	 * @return success.
	 * @throws Exception
	 *             if something goes wrong.
	 */
	public Event createScrumNote(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		ScrumNote aNewNote = form.getNewNote();
		aNewNote.setScrumBoard(scrumBoard);
		aNewNote.setState(NoteState.NOT_STARTED);
		
		aNewNote = actionDelegate.createNewScrumNote(aNewNote);

		form.setNewNote(new ScrumNote());
		updateNoteLists();

		return success();
	}

	/**
	 * This method shows the scrumBoard.
	 * 
	 * @param context
	 *            the context containing the form object
	 * @return success.
	 * @throws Exception
	 *             if something goes wrong.
	 */
	public Event showScrumBoard(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		ScrumBoard updatedScrumBoard = actionDelegate.getNewestScrumboard();
		form.setBoard(updatedScrumBoard);

		scrumBoard = form.getBoard();
		updateNoteLists();

		return success();
	}

	/**
	 * Handles drop events for inProgress notes
	 * 
	 * @param event
	 *            DropEvent to handle
	 */
	public void dropToInProgress(DropEvent event) {
		ScrumNote note = (ScrumNote) event.getDragValue();
		actionDelegate.moveToInProgress(note.getNoteId());
		updateNoteLists();
	}

	/**
	 * Handles drop events for done notes
	 * 
	 * @param event
	 *            DropEvent to handle
	 */
	public void dropToDone(DropEvent event) {
		ScrumNote note = (ScrumNote) event.getDragValue();
		actionDelegate.moveToDone(note.getNoteId());
		updateNoteLists();
	}

	/**
	 * Handles drop events for not started notes
	 * 
	 * @param event
	 *            DropEvent to handle
	 */
	public void dropToNotStarted(DropEvent event) {
		ScrumNote note = (ScrumNote) event.getDragValue();
		actionDelegate.moveToNotStarted(note.getNoteId());
		updateNoteLists();
	}

	/**
	 * @return the actionDelegate
	 */
	public ScrumBoardActionDelegate getActionDelegate() {
		return actionDelegate;
	}

	/**
	 * @param actionDelegate
	 *            the actionDelegate to set
	 */
	public void setActionDelegate(ScrumBoardActionDelegate actionDelegate) {
		this.actionDelegate = actionDelegate;
	}

	/**
	 * @return the scrumBoard
	 */
	public ScrumBoard getScrumBoard() {
		return scrumBoard;
	}

	/**
	 * @param scrumBoard
	 *            the scrumBoard to set
	 */
	public void setScrumBoard(ScrumBoard scrumBoard) {
		this.scrumBoard = scrumBoard;
	}

	/**
	 * @return the notStartedList
	 */
	public List<ScrumNote> getNotStartedList() {
		return notStartedList;
	}

	/**
	 * @param notStartedList the notStartedList to set
	 */
	public void setNotStartedList(List<ScrumNote> notStartedList) {
		this.notStartedList = notStartedList;
	}

	/**
	 * @return the inProgressList
	 */
	public List<ScrumNote> getInProgressList() {
		return inProgressList;
	}

	/**
	 * @param inProgressList the inProgressList to set
	 */
	public void setInProgressList(List<ScrumNote> inProgressList) {
		this.inProgressList = inProgressList;
	}

	/**
	 * @return the doneList
	 */
	public List<ScrumNote> getDoneList() {
		return doneList;
	}

	/**
	 * @param doneList the doneList to set
	 */
	public void setDoneList(List<ScrumNote> doneList) {
		this.doneList = doneList;
	}

	private void updateNoteLists(){
		setNotStartedList(actionDelegate.getScrumNotesByState(NoteState.NOT_STARTED));
		setInProgressList(actionDelegate.getScrumNotesByState(NoteState.IN_PROGRESS));
		setDoneList(actionDelegate.getScrumNotesByState(NoteState.DONE));
	}

}
