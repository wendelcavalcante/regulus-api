package br.jus.trece.regulusApi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import br.jus.trece.regulusApi.db.regulus.domain.Parametro;
import br.jus.trece.regulusApi.db.regulus.repo.ParametroRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SessionScope
public class LoginBean {

    @Autowired
    private ParametroRepository parametroRepository;

    private boolean logged = false;

    private Parametro parametro;

    public void entrar() {
        String s = parametroRepository.findById(1).get().getUrlSegurancaTre();
        System.out.println("teste 123 "+s);
        logged = true;
    }

    public void isLogged() {
        System.out.println("logado: "+logged);
    }

}
