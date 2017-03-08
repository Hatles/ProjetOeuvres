package projetoeuvres.dao;

import projetoeuvres.meserreurs.MyException;
import projetoeuvres.metier.*;
import projetoeuvres.persistance.DBAccess;

import java.awt.print.Book;
import java.util.*;


public class Service {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertMember(Member member) throws MyException {
		String mysql;

		DBAccess dbAccess = DBAccess.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ member.getName();
			mysql += "'" + ",'" + member.getFirstName() + "','" + member.getCity() + "')";

			dbAccess.insert(mysql);
		} catch (MyException e) {
			throw e;
		}
	}

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Member getMember(int numero) throws MyException {
		String mysql = "select * from adherent where id_adherent=" + numero;
		List<Member> members = getMembers(mysql);
		if (members.isEmpty())
			return null;
		else {
			return members.get(0);
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Member> getMembers() throws MyException {
		String mysql = "select * from adherent";
		return getMembers(mysql);
	}

	private List<Member> getMembers(String mysql) throws MyException {
		List<Object> rs;
		List<Member> members = new ArrayList<Member>();
		int index = 0;
		try {
			DBAccess dbAccess = DBAccess.getInstance();
			rs = DBAccess.read(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Member member = new Member();
				// il faut redecouper la liste pour retrouver les lignes
				member.setId(Integer.parseInt(rs.get(index + 0).toString()));
				member.setName(rs.get(index + 1).toString());
				member.setFirstName(rs.get(index + 2).toString());
				member.setCity(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				members.add(member);
			}

			return members;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<WorkOnLoan> getWorksOnLoan() throws MyException {
		String mysql = "select * from oeuvrepret";
		return getWorksOnLoan(mysql);
	}

	private List<WorkOnLoan> getWorksOnLoan(String mysql) throws MyException {
		List<Object> rs;
		List<WorkOnLoan> worksOnLoan = new ArrayList<WorkOnLoan>();
		int index = 0;
		try {
			rs = DBAccess.read(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				WorkOnLoan workOnLoan = new WorkOnLoan();
				// il faut redecouper la liste pour retrouver les lignes
				workOnLoan.setId(Integer.parseInt(rs.get(index + 0).toString()));
				workOnLoan.setTitle(rs.get(index + 1).toString());
				workOnLoan.setOwner(getOwner(Integer.parseInt(rs.get(index + 2).toString())));
				// On incr�mente tous les 2 champs
				index = index + 3;
				worksOnLoan.add(workOnLoan);
			}

			return worksOnLoan;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

	public WorkForSale getWorkForSale(int id) throws MyException {
		String mysql = "select * from oeuvrevente where id_oeuvrevente=" + id;
		List<WorkForSale> worksForSale = getWorksForSale(mysql);
		if (worksForSale.isEmpty())
			return null;
		else {
			return worksForSale.get(0);
		}
	}

	public List<WorkForSale> getWorksForSale() throws MyException {
		String mysql = "select * from oeuvrevente";
		return getWorksForSale(mysql);
	}

	private List<WorkForSale> getWorksForSale(String mysql) throws MyException {
		List<Object> rs;
		List<WorkForSale> worksForSale = new ArrayList<WorkForSale>();
		int index = 0;
		try {
			rs = DBAccess.read(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				WorkForSale workForSale = new WorkForSale();
				// il faut redecouper la liste pour retrouver les lignes
				workForSale.setId(Integer.parseInt(rs.get(index + 0).toString()));
				workForSale.setTitle(rs.get(index + 1).toString());
				workForSale.setState(rs.get(index + 2).toString());
				workForSale.setPrice(Float.parseFloat(rs.get(index + 3).toString()));
				workForSale.setOwner(getOwner(Integer.parseInt(rs.get(index + 4).toString())));
				// On incr�mente tous les 2 champs
				index = index + 5;
				worksForSale.add(workForSale);
			}

			return worksForSale;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

	public Owner getOwner(int id) throws MyException {
		String mysql = "select * from proprietaire where id_proprietaire="+ id;
		List<Owner> owners = getOwners(mysql);
		if (owners.isEmpty())
			return null;
		else {
			return owners.get(0);
		}
	}

	public List<Owner> getOwners() throws MyException {
		String mysql = "select * from proprietaire";
		return getOwners(mysql);
	}

	private List<Owner> getOwners(String mysql) throws MyException {
		List<Object> rs;
		List<Owner> owners = new ArrayList<Owner>();
		int index = 0;
		try {
			DBAccess dbAccess = DBAccess.getInstance();
			rs = DBAccess.read(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Owner owner = new Owner();
				// il faut redecouper la liste pour retrouver les lignes
				owner.setId(Integer.parseInt(rs.get(index + 0).toString()));
				owner.setName(rs.get(index + 1).toString());
				owner.setFirstName(rs.get(index + 2).toString());
				// On incr�mente tous les 3 champs
				index = index + 3;
				owners.add(owner);
			}

			return owners;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

	public void insertWorkForSale(WorkForSale workForSale) throws MyException {
		String mysql;

		DBAccess dbAccess = DBAccess.getInstance();
		try {
			mysql = "insert into oeuvrevente (titre_oeuvrevente,etat_oeuvrevente,prix_oeuvrevente,id_proprietaire)  " + "values ('"
					+ workForSale.getTitle();
			mysql += "'" + ",'" + workForSale.getState() + "','" + workForSale.getPrice() + "','" + workForSale.getOwner().getId() + "')";

			dbAccess.insert(mysql);
		} catch (MyException e) {
			throw e;
		}
	}

	public void insertWorkOnLoan(WorkOnLoan workOnLoan) throws MyException {
		String mysql;

		DBAccess dbAccess = DBAccess.getInstance();
		try {
			mysql = "insert into oeuvrepret (titre_oeuvrepret,id_proprietaire)  " + "values ('"
					+ workOnLoan.getTitle();
			mysql += "'" + ",'" + workOnLoan.getOwner().getId() + "')";

			dbAccess.insert(mysql);
		} catch (MyException e) {
			throw e;
		}
	}

	public void insertBooking(Booking booking) throws MyException {
		String mysql;

		DBAccess dbAccess = DBAccess.getInstance();
		try {
			mysql = "insert into reservation (id_oeuvrevente,id_adherent,date_reservation,statut)  " + "values ('"
					+ booking.getWorkForSale().getId();
			mysql += "'" + ",'" + booking.getMember().getId() + "','" + booking.getDate() + "','" + "en attente" + "')";

			dbAccess.insert(mysql);
		} catch (MyException e) {
			throw e;
		}
	}

	public void removeWorkForSale(WorkForSale workForSale) throws MyException {
		String mysql;

		DBAccess dbAccess = DBAccess.getInstance();
		try {
			mysql = "delete from reservation where id_oeuvrevente="
					+ workForSale.getId();

			dbAccess.execute(mysql);

			mysql = "delete from oeuvrevente where id_oeuvrevente="
					+ workForSale.getId();

			dbAccess.execute(mysql);
		} catch (MyException e) {
			throw e;
		}
	}

    public Booking getBooking(int idWork, int idMember) throws MyException {
        String mysql = "select * from reservation where id_oeuvrevente="+ idWork+" id_adherent="+ idMember;
        List<Booking> bookings = getBookings(mysql);
        if (bookings.isEmpty())
            return null;
        else {
            return bookings.get(0);
        }
    }

	public List<Booking> getBookings(boolean waiting) throws MyException {
		String mysql = "select * from reservation";
		if(waiting)
			mysql += " where statut='en attente'";
		return getBookings(mysql);
	}

	private List<Booking> getBookings(String mysql) throws MyException {
		List<Object> rs;
		List<Booking> bookings = new ArrayList<Booking>();
		int index = 0;
		try {
			rs = DBAccess.read(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Booking booking = new Booking();
				// il faut redecouper la liste pour retrouver les lignes
                booking.setWorkForSale(getWorkForSale(Integer.parseInt(rs.get(index + 0).toString())));
                booking.setMember(getMember(Integer.parseInt(rs.get(index + 1).toString())));
                booking.setDate(java.sql.Date.valueOf(rs.get(index + 2).toString()));
                booking.setStatus(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				bookings.add(booking);
			}

			return bookings;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}
}
