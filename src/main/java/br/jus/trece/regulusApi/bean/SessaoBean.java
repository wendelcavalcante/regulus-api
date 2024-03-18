package br.jus.trece.regulusApi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.jus.trece.regulusApi.db.regulus.domain.Parametro;
import br.jus.trece.regulusApi.db.regulus.repo.ParametroRepository;
import jakarta.annotation.PostConstruct;

@Component
@SessionScope
public class SessaoBean {
    
    private Parametro parametro;

    @Autowired
    ParametroRepository parametroRepository;

    @PostConstruct
    protected void init() {
        this.parametro = parametroRepository.findById(1).get();
    }

}
