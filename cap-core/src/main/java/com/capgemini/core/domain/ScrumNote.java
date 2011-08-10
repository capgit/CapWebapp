package com.capgemini.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.capgemini.core.NoteState;

/**
 * 
 * @author Sanjin Cevro (Capgemini)
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "scrumNote.getNotesByState", query = " from ScrumNote n where n.state=:state") })
public class ScrumNote implements Serializable {

	private static final long serialVersionUID = 3525668941668735342L;

	@Id
	@GeneratedValue
	private Long noteId;
	private String headline;
	private String description;
	private Integer estimate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate = new Date();

	@Enumerated(EnumType.ORDINAL)
	private NoteState state;

	@ManyToOne
	@JoinColumn(name = "scrumBoard", nullable = false)
	private ScrumBoard scrumBoard;

	/**
	 * @return the noteId
	 */
	public Long getNoteId() {
		return noteId;
	}

	/**
	 * @param noteId
	 *            the noteId to set
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
	 * @param headline
	 *            the headline to set
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
	 * @param description
	 *            the description to set
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
	 * @param estimate
	 *            the estimate to set
	 */
	public void setEstimate(Integer estimate) {
		this.estimate = estimate;
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
	 * @return the state
	 */
	public NoteState getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(NoteState state) {
		this.state = state;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
