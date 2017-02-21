package projetoeuvres.metier;

import java.io.Serializable;


/**
 * The persistent class for the oeuvrevente database table.
 * 
 */

public class WorkForSale implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String state;
	private float price;
	private String title;
	private Owner owner;


	public WorkForSale(int id, String state, float price, String title,
			Owner owner) {
		super();
		this.id = id;
		this.state = state;
		this.price = price;
		this.title = title;
		this.owner = owner;
	}

	public WorkForSale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
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