package com.capgemini.scrumboard;

import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;

/**
 * Main action class for the scrum board webapp.
 * @author Henrik Hahne (Capgemini)
 *
 */
//TODO: Validation !
public class ScrumBoardAction extends FormAction {
	
	ScrumBoardActionDelegate actionDelegate;

	/* (non-Javadoc)
	 * @see org.springframework.webflow.action.FormAction#createFormObject(org.springframework.webflow.execution.RequestContext)
	 */
	@Override
	protected Object createFormObject(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		form.setNewNote(new ScrumNote());
		form.setBoard(actionDelegate.getNewestScrumboard());
		return super.createFormObject(context);
		
	}

	/**
	 * This method should be called when the user presses the "create note" button.
	 * @param context the context containing the form with the new ScrumNote to create
	 * @return success.
	 * @throws Exception if something goes wrong.
	 */
	public Event createScrumNote(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		ScrumNote aNewNote = form.getNewNote();
		ScrumBoard updatedScrumBoard = actionDelegate.createNewScrumNote(aNewNote);
		form.setBoard(updatedScrumBoard);
		return success();
	}

	/**
	 * This method shows the scrumBoard.
	 * @param context the context containing the form object
	 * @return success.
	 * @throws Exception if something goes wrong.
	 */
	public Event showScrumBoard(RequestContext context) throws Exception {
		ScrumBoardForm form = (ScrumBoardForm) this.getFormObject(context);
		ScrumBoard updatedScrumBoard = actionDelegate.getNewestScrumboard();
		form.setBoard(updatedScrumBoard);
		return success();
	}
	
	/**
	 * @return the actionDelegate
	 */
	public ScrumBoardActionDelegate getActionDelegate() {
		return actionDelegate;
	}

	/**
	 * @param actionDelegate the actionDelegate to set
	 */
	public void setActionDelegate(ScrumBoardActionDelegate actionDelegate) {
		this.actionDelegate = actionDelegate;
	}	
	
	
}
