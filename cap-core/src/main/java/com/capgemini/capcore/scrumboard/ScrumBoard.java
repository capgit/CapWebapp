package com.capgemini.capcore.scrumboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 * 
 */
public class ScrumBoard implements Serializable {

	private static final long serialVersionUID = -6243959646151989431L;
	
	private static ScrumBoard instance;
	private List<ScrumNote> notStartedList;
	private List<ScrumNote> inProgressList;
	private List<ScrumNote> doneList;
	
	private ScrumBoard() {
		//Make the constructor private so this will be a singletin
	}
	
	/**
	 * Singleton method - gets a new instance if none exists or return the existing one.
	 * @return a ScrumBoard
	 */
	public static ScrumBoard getInstance() {
		if(instance == null) {
			instance = new ScrumBoard();
			instance.notStartedList = new ArrayList<ScrumNote>();
			instance.inProgressList = new ArrayList<ScrumNote>();
			instance.doneList = new ArrayList<ScrumNote>();
		}
		return instance;
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
	 * @param inProgressLit the inProgressList to set
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
	
}
