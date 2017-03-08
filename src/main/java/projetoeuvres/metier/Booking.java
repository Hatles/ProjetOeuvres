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
	private Member member;
	private WorkForSale workForSale;
	private String status;

	public Booking() {
	}

	public Booking(Date date, Member member, WorkForSale workForSale, String status) {
		super();
		this.date = date;
		this.member = member;
		this.workForSale = workForSale;
		this.status = status;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public WorkForSale getWorkForSale() {
		return this.workForSale;
	}

	public void setWorkForSale(WorkForSale workForSale) {
		this.workForSale = workForSale;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}