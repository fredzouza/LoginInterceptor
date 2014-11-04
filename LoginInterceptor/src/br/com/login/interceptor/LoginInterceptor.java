package br.com.login.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.login.model.UsuarioSession;

@Intercepts
public class LoginInterceptor implements Interceptor {

	private final Result result;
	private final UsuarioSession usuarioSession;

	public LoginInterceptor(Result result, UsuarioSession usuarioSession) {
		super();
		this.result = result;
		this.usuarioSession = usuarioSession;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return !(method.getMethod().isAnnotationPresent(Security.class) || method
				.getResource().getType().isAnnotationPresent(Security.class));
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod arg1,
			Object arg2) throws InterceptionException {

		if (usuarioSession != null) {

		}
	}

}
