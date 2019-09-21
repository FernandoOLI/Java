# Java
Algumas funções em java, conexoes usando JDBC e arquivos pom para aplicações web-server's

ProjectName.java: a main do projeto, o framework utilizado é o SpringBoot

os arquivos pom: são para o Maven para automatizar a compilação. Está o principal, server e web, 
já está referenciado no pom principal

SecurityConfig.java: COnfigurações simples de segurança

SQLServerConfig: Onde ocorre a leitura dos dados para a conexão com o BD SQLServer.

Conexao.java: chama a classe SQLServerConfig, para fazer a conexão de forma segura.

ConnectionController.java: Controlador que recebe a requisição http e posteriormente fecha a conexão com o BD
