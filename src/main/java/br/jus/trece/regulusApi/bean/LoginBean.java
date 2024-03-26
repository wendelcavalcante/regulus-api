package br.jus.trece.regulusApi.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.jus.trece.api.domain.Token;
import br.jus.trece.api.domain.corporativo.Usuario;
import br.jus.trece.regulusApi.client.TreApiClient;
import br.jus.trece.regulusApi.db.regulus.domain.Parametro;
import br.jus.trece.regulusApi.db.regulus.repo.ParametroRepository;

import org.springframework.context.annotation.Bean;
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

    public Token entrar(String login, String senha) {
        Token token = treApiClient.autenticar(login, senha);
        this.sessaoBean.setToken(token);
        Integer matricula = treApiClient.buscarMatriculaPorLogin(login);
        String matString = String.format("%05d", matricula);
        Usuario usuario = treApiClient.buscarUsuarioPorId(matString);
        List<String> perfis = treApiClient.listarPerfis((long)this.sessaoBean.getParametro().getIdSistema(), matString);
        System.out.println("resultado: "+perfis.get(0));
        return token;
    }

    public void isLogged() {
        System.out.println("logado: "+logged);
    }

}
