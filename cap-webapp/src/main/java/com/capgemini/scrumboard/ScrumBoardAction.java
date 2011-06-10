package com.capgemini.scrumboard;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.capgemini.capcore.scrumboard.ScrumNote;

/**
 * Main action class for the scrum board webapp.
 * @author Henrik Hahne (Capgemini)
 *
 */
public class ScrumBoardAction extends FormAction {
	
	ScrumBoardActionDelegate actionDelegate;

	/* (non-Javadoc)
	 * @see org.springframework.webflow.action.FormAction#createFormObject(org.springframework.webflow.execution.RequestContext)
	 */
	@Override
	protected Object createFormObject(RequestContext context) throws Exception {
		// TODO Auto-generated method stub
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
		ScrumNote persistedScrumNote = actionDelegate.createNewScrumNote(aNewNote);
		form.reset();
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
