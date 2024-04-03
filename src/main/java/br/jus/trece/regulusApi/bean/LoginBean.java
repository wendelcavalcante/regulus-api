package br.jus.trece.regulusApi.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.jus.trece.api.domain.Token;
import br.jus.trece.api.domain.corporativo.Usuario;
import br.jus.trece.regulusApi.client.TreApiClient;
import br.jus.trece.regulusApi.db.regulus.domain.Parametro;
import br.jus.trece.regulusApi.db.regulus.repo.ParametroRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
@SessionScope
public class LoginBean {

    @Autowired
    private ParametroRepository parametroRepository;

    @Autowired
    private TreApiClient treApiClient;

    @Autowired
    private SessaoBean sessaoBean;

    private boolean logged = false;

    private SecurityContextRepository securityContextRepository =
        new HttpSessionSecurityContextRepository();

    public Token entrar(String login, String senha) {
        Token token = treApiClient.autenticar(login, senha);
        this.sessaoBean.setToken(token);
        Integer matricula = treApiClient.buscarMatriculaPorLogin(login);
        String matString = String.format("%05d", matricula);
        Usuario usuario = treApiClient.buscarUsuarioPorId(matString);
        List<String> perfis = treApiClient.listarPerfis((long)this.sessaoBean.getParametro().getIdSistema(), matString);
        System.out.println("resultado: "+perfis.get(0));

        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
        final UserDetails principal = new User(login, senha, grantedAuths);
        Authentication authenticated = new UsernamePasswordAuthenticationToken(
                principal, senha, principal.getAuthorities());
        
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authenticated);
        //Authentication auth = authManager.authenticate(authReq);
        return token;
    }

    public void isLogged() {
        System.out.println("logado: "+logged);
    }

}
