package com.capgemini.capcore.scrumboard;

import java.io.Serializable;

/**
 * @author Sanjin Cevro (Capgemini)
 * @author Henrik Hahne (Capgemini)
 *
 */
public class ScrumNote implements Serializable {

	private static final long serialVersionUID = 3575153646727198458L;

	private Long noteId;
	private String headline;
	private String description;
	private Integer estimate;
	
	/**
	 * @return the noteId
	 */
	public Long getNoteId() {
		return noteId;
	}
	
	/**
	 * @param noteId the noteId to set
	 */
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	
	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}
	
	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the estimate
	 */
	public Integer getEstimate() {
		return estimate;
	}
	
	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(Integer estimate) {
		this.estimate = estimate;
	}
	
	
}
