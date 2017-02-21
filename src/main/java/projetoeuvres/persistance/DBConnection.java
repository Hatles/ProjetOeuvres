package projetoeuvres.persistance;

import projetoeuvres.meserreurs.MyException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
	private Connection conn = null;
	private static DBConnection instance = null;

	// On utilise un singleton
	public static DBConnection getInstance() {
		if (instance == null)
			instance = new DBConnection();
		return instance;
	}

	// on rend le constructeur priv�
	// pour emp�cher toute cr�ation d'instance
	private DBConnection() {
	}

	public Connection getConnection() throws MyException {
		Connection conn = null;
		try {
			Context ctxt = new InitialContext();
			// On r�cup�re l'environnement
			Context envCtx = (Context) ctxt.lookup("java:comp/env");
			// On recherche la data source
			DataSource ds = (DataSource) envCtx.lookup("jdbc/DSOeuvre");
			conn = ds.getConnection();

		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		}
		return conn;
	}

}
