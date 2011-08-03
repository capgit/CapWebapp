package com.capgemini.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Sanjin Cevro (Capgemini)
 *
 */
@Entity
public class ScrumBoard implements Serializable{

	private static final long serialVersionUID = -6905234905616620515L;

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "scrumBoard")
	private List<ScrumNote> scrumNotes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the scrumNotes
	 */
	public List<ScrumNote> getScrumNotes() {
		return scrumNotes;
	}

	/**
	 * @param scrumNotes the scrumNotes to set
	 */
	public void setScrumNotes(List<ScrumNote> scrumNotes) {
		this.scrumNotes = scrumNotes;
	}
	
}
