package br.com.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.login.model.Usuario;

@Component
public class UsuarioDao {

	private EntityManager em = new ConnectionFactory().openConnection();

	public Usuario find(Usuario usuario){
		return em.find(Usuario.class, usuario);
	}
	
	public Usuario validaUsuario(Usuario usuario){
		String sql = "from Usuario where login = :login and senha = :senha";
		TypedQuery<Usuario> q = em.createQuery(sql, Usuario.class);
		q.setParameter("login", usuario.getLogin());
		q.setParameter("senha", usuario.getSenha());
		
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
