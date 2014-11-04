package br.com.login.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.login.dao.UsuarioDao;
import br.com.login.model.Usuario;
import br.com.login.model.UsuarioSession;

@Resource
public class LoginController {

	private final Result result;
	private final UsuarioSession usuarioSession;
	private final UsuarioDao usuarioDao;

	public LoginController(Result result,
			UsuarioSession usuarioSession,
			UsuarioDao usuarioDao) {
		super();
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.usuarioDao = usuarioDao;
	}

	@Get
	@Path({ "", "/login" })
	public void login(){
	}
	
	@Post
	@Path("/login")
	public void login(String login, String senha){
		Usuario usuario = new Usuario(login, senha);
		usuario = usuarioDao.validaUsuario(usuario);
		
		if (usuario != null) {
			usuarioSession.setId(usuario.getId());
			usuarioSession.setLogin(usuario.getLogin());
			usuarioSession.setSenha(usuario.getSenha());
			
			result.redirectTo(IndexController.class).index();
		} else {
			result.include("error", "Login e/ou Senha incorretos").redirectTo(this).login();
		}
	}
	
}
