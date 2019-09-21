package com.example.ProjectName;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

	private static Connection con = SQLServerConf.sqlServerClient();

	public static Connection get() {
		return con;
	}

	public static void closeAll() throws SQLException {
		SQLServerConf.safeCloseConnection(con);
	}

}
