package projetoeuvres.metier;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the pret database table.
 * 
 */
public class Loan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Date date;
	private int duration;
	private WorkOnLoan workOnLoan;
	private Member member;

	
	public Loan(Date date, int duration, WorkOnLoan workOnLoan, Member member) {
		super();
		this.date = date;
		this.duration = duration;
		this.workOnLoan = workOnLoan;
		this.member = member;
	}

	public Loan() {
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duree) {
		this.duration = duration;
	}

	public WorkOnLoan getWorkOnLoan() {
		return this.workOnLoan;
	}

	public void setWorkOnLoan(WorkOnLoan workOnLoan) {
		this.workOnLoan = workOnLoan;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member adherent) {
		this.member = member;
	}

}