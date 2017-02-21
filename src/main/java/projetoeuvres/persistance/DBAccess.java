package projetoeuvres.persistance;

import projetoeuvres.meserreurs.MyException;

import java.sql.*;
import java.util.*;

public class DBAccess {

	private static DBAccess instance = null;

	public static DBAccess getInstance() {
		if (instance == null) {
			instance = new DBAccess();
		}
		return instance;
	}

	private DBAccess() {
		super();
	}

	public void insert(String mysql) throws MyException {
		Connection cnx = null;
		try {
			cnx = DBConnection.getInstance().getConnection();
			Statement unstatement = cnx.createStatement();
			unstatement.execute(mysql);
			// on ferme la connexion
			cnx.close();
		} catch (SQLException e)

		{
			System.out.println("Erreur :" + e.getMessage());
			System.out.println(mysql);
			new MyException(e.getMessage());
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(e.getMessage());
		}
	}

	public static List<Object> read(String req) throws MyException {
		Connection cnx = null;
		Statement stmt;
		ResultSet rs;
		List<Object> mesRes = new ArrayList<Object>();
		int i;
		int nbCols;
		try {

			cnx = DBConnection.getInstance().getConnection();
			stmt = cnx.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			// Execution de la requete
			rs = stmt.executeQuery(req);
			// on retrouve le nombre de colonnes de la requ�te
			ResultSetMetaData rsmd = rs.getMetaData();
			nbCols = rsmd.getColumnCount();
			i = 1;
			// on balaie toutes les lignes
			while (rs.next()) {

				// On balaie les colonnes
				i = 1;
				while (i <= nbCols) {
					mesRes.add(rs.getObject(i));
					i++;
				}
			}
			cnx.close();
			// Retourner la table
			return (mesRes);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new MyException(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(e.getMessage());
		} finally {
			// S'il y a eu un probl�me, la connexion
			// peut �tre encore ouverte, dans ce cas
			// il faut la fermer.

			if (cnx != null)
				try {
					cnx.close();
				} catch (SQLException e) {
				}
		}
	}

	public void execute(String mysql) throws MyException {
		Connection cnx = null;
		try {
			cnx = DBConnection.getInstance().getConnection();
			Statement unstatement = cnx.createStatement();
			unstatement.execute(mysql);
			System.out.println(mysql);
			// on ferme la connexion
			cnx.close();
		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(e.getMessage());
		}
	}

}
