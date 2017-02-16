package projetoeuvres.dao;

import projetoeuvres.meserreurs.MonException;
import projetoeuvres.metier.Adherent;
import projetoeuvres.metier.Oeuvrepret;
import projetoeuvres.metier.Oeuvrevente;
import projetoeuvres.metier.Proprietaire;
import projetoeuvres.persistance.DialogueBd;
import java.util.*;


public class Service {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insertAdherent(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}


	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Adherent consulterAdherent(int numero) throws MonException {
		String mysql = "select * from adherent where numero_adherent=" + numero;
		List<Adherent> mesAdh = consulterListeAdherents(mysql);
		if (mesAdh.isEmpty())
			return null;
		else {
			return mesAdh.get(0);
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> consulterListeAdherents() throws MonException {
		String mysql = "select * from adherent";
		return consulterListeAdherents(mysql);
	}

	private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
		List<Object> rs;
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Adherent unA = new Adherent();
				// il faut redecouper la liste pour retrouver les lignes
				unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
				unA.setNomAdherent(rs.get(index + 1).toString());
				unA.setPrenomAdherent(rs.get(index + 2).toString());
				unA.setVilleAdherent(rs.get(index + 3).toString());
				// On incr�mente tous les 3 champs
				index = index + 4;
				mesAdherents.add(unA);
			}

			return mesAdherents;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Oeuvrepret> consulterListeOeuvresPrets() throws MonException {
		String mysql = "select * from oeuvrepret";
		return consulterListeOeuvresPrets(mysql);
	}

	private List<Oeuvrepret> consulterListeOeuvresPrets(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrepret> mesOeuvresPrets = new ArrayList<Oeuvrepret>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Oeuvrepret oeuvrePret = new Oeuvrepret();
				// il faut redecouper la liste pour retrouver les lignes
				oeuvrePret.setIdOeuvrepret(Integer.parseInt(rs.get(index + 0).toString()));
				oeuvrePret.setTitreOeuvrepret(rs.get(index + 1).toString());
				oeuvrePret.setProprietaire(getProprieteaire(Integer.parseInt(rs.get(index + 2).toString())));
				// On incr�mente tous les 2 champs
				index = index + 3;
				mesOeuvresPrets.add(oeuvrePret);
			}

			return mesOeuvresPrets;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	public List<Oeuvrevente> consulterListeOeuvresVentes() throws MonException {
		String mysql = "select * from oeuvrevente";
		return consulterListeOeuvresVentes(mysql);
	}

	private List<Oeuvrevente> consulterListeOeuvresVentes(String mysql) throws MonException {
		List<Object> rs;
		List<Oeuvrevente> mesOeuvresPrets = new ArrayList<Oeuvrevente>();
		int index = 0;
		try {
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On cr�e un stage
				Oeuvrevente oeuvreVente = new Oeuvrevente();
				// il faut redecouper la liste pour retrouver les lignes
				oeuvreVente.setIdOeuvrevente(Integer.parseInt(rs.get(index + 0).toString()));
				oeuvreVente.setTitreOeuvrevente(rs.get(index + 1).toString());
				oeuvreVente.setEtatOeuvrevente(rs.get(index + 2).toString());
				oeuvreVente.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));
				oeuvreVente.setProprietaire(getProprieteaire(Integer.parseInt(rs.get(index + 4).toString())));
				// On incr�mente tous les 2 champs
				index = index + 5;
				mesOeuvresPrets.add(oeuvreVente);
			}

			return mesOeuvresPrets;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

	private Proprietaire getProprieteaire(int id) throws MonException {
		try {
			List<Object> rs = DialogueBd.lecture("select * from proprietaire where id_proprietaire="+ id);
			Proprietaire proprietaire = new Proprietaire();
			proprietaire.setIdProprietaire(id);
			proprietaire.setNomProprietaire(rs.get(1).toString());
			proprietaire.setPrenomProprietaire(rs.get(2).toString());
			return proprietaire;
		} catch (Exception exc) {
			throw new MonException(exc.getMessage(), "systeme");
		}
	}

}
