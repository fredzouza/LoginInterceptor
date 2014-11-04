package br.com.login.model;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioSession extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

}
