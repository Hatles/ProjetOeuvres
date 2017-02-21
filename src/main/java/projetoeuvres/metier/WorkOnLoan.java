package projetoeuvres.metier;

import java.io.Serializable;


/**
 * The persistent class for the oeuvrepret database table.
 * 
 */

public class WorkOnLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private Owner owner;

	
	public WorkOnLoan(int id, String title, Owner owner) {
		super();
		this.id = id;
		this.title = title;
		this.owner = owner;
	}

	public WorkOnLoan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}