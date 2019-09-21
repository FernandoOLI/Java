package com.example.ProjectName;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Exemplo de conexão com Banco SQL Server usando JDBC 
@Configuration
public class SQLServerConf {

	public @Bean static Connection sqlServerClient() {
		Connection con = null;
		FileInputStream input = null;
		try {
			//Os dados do usuario e a senha devem estar em arquivos criptografados e separados da aplicação
			//não é uma boa prática deixar esses dados em hard code
			input = new FileInputStream("src/main/resources/file_read.properties");
			Properties prop = new Properties();
			prop.load(input);
			String j_u = new String(Base64.getDecoder().decode(prop.getProperty("j_u").getBytes()));
			String j_p = new String(Base64.getDecoder().decode(prop.getProperty("j_p").getBytes()));
			String j_url = new String(Base64.getDecoder().decode(prop.getProperty("j_url").getBytes()));

			String connectionUrl = j_url.replace("%j_u%", j_u).replace("%j_p%", j_p);
			con = DriverManager.getConnection(connectionUrl);
			return con;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				safeCloseFile(input);
			}
		}
		return con;

	}

	public static void safeCloseFile(FileInputStream fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//No fim de sua aplicação (por exemplo no Logout) é recomendável fechar a conexão com o BD
	public static void safeCloseConnection(Connection fis) {
		if (fis != null) {
			try {
				fis.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
