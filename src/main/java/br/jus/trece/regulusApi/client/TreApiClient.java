package br.jus.trece.regulusApi.client;

import br.jus.trece.api.domain.Token;
import br.jus.trece.api.domain.corporativo.Usuario;
import br.jus.trece.regulusApi.bean.SessaoBean;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

@Component
public class TreApiClient {

    @Autowired
    SessaoBean sessaoBean;

    public Token autenticar(String login, String senha) {
        Client client = Client.create();
        WebResource webResource = client.resource(sessaoBean.getParametro().getUrlSegurancaTre() + "/autenticar");
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, getUsuarioJson(login, senha));

        if (response.getStatus() == 200) {
            JsonObject jo = new Gson().fromJson(response.getEntity(String.class), JsonObject.class);
            return new Gson().fromJson(jo, new TypeToken<Token>() {}.getType());
        } else {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(response.getStatus()));
        }
    }

    public Integer buscarMatriculaPorLogin(String login) {
		Client client = Client.create();
			
        WebResource webResource = client.resource(sessaoBean.getParametro().getUrlSegurancaTre()
                + "/matricula");
        ClientResponse response = webResource.queryParam("login", login)
                                                .type(MediaType.APPLICATION_JSON)
                                                .get(ClientResponse.class);

        if (response.getStatus() == 200) {
            JsonPrimitive jp = new Gson().fromJson(response.getEntity(String.class), JsonPrimitive.class);
            return new Gson().fromJson(jp, new TypeToken<Integer>() {}.getType());
        } else {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(response.getStatus()));
        }
	}

    public Usuario buscarUsuarioPorId(String matricula) {
        Client client = Client.create();
        
        WebResource webResource = client.resource(this.sessaoBean.getParametro().getUrlEntidade()
                + "/usuarios/" + matricula);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                                                .header("Authorization", sessaoBean.getToken().toString())
                                                .get(ClientResponse.class);
        // resposta ok.
        if (response.getStatus() == HttpStatus.OK.value()) {
            JsonObject jo = new Gson().fromJson(response.getEntity(String.class), JsonObject.class);

            return new Gson().fromJson(jo, new TypeToken<Usuario>() {}.getType());
        // token expirado.
        } else {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(response.getStatus()));
        }
	}

    public List<String> listarPerfis(Long sistema, String matricula) {
        Client client = Client.create();
        
        WebResource webResource = client.resource(this.sessaoBean.getParametro().getUrlEntidade()
                + "/perfis" + "/descricoes");
        ClientResponse response = webResource.queryParam("sistema", sistema.toString())
                                                .queryParam("matricula", matricula)
                                                .type(MediaType.APPLICATION_JSON)
                                                .header("Authorization", this.sessaoBean.getToken().toString())
                                                .get(ClientResponse.class);

        if (response.getStatus() == HttpStatus.OK.value()) {
            JsonArray ja = new Gson().fromJson(response.getEntity(String.class), JsonArray.class);
            return new Gson().fromJson(ja, new TypeToken<List<String>>() {}.getType());
        } else {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(response.getStatus()));
        }
    }



    private String getUsuarioJson(String login, String senha) {
		JsonObject jo = new JsonObject();
		jo.addProperty("login", login);
		jo.addProperty("senha", senha);

		return new Gson().toJson(jo, JsonObject.class);
	}

}
