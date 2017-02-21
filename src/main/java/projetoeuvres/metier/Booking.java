package projetoeuvres.metier;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Owner owner;
	private WorkForSale workForSale;

	public Booking() {
	}

	public Booking(Date date, Owner owner, WorkForSale workForSale) {
		super();
		this.date = date;
		this.owner = owner;
		this.workForSale = workForSale;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public WorkForSale getWorkForSale() {
		return this.workForSale;
	}

	public void setWorkForSale(WorkForSale workForSale) {
		this.workForSale = workForSale;
	}

}