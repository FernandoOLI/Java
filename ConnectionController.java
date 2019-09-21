package com.example.ProjectName;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/login" })
public class ConnectionController {
	//Página de logout encerra a conexão com BD
	@GetMapping(path = "/logout")
	public void logout(HttpServletRequest request) throws ServletException, SQLException {
		Conexao.closeAll();
		request.logout();
	}

}
