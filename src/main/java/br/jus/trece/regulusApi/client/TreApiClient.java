package br.jus.trece.regulusApi.client;

import br.jus.trece.api.domain.Token;
import br.jus.trece.regulusApi.bean.SessaoBean;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

public class TreApiClient {

    @Autowired
    SessaoBean sessaoBean;

    public Token autenticar(String login, String senha) {
        Client client = Client.create();

        WebResource webResource = client.resource(sessaoBean.getParametro() + "/autenticar");

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, getUsuarioJson(login, senha));

        if (response.getStatus() == 200) {
            JsonObject jo = new Gson().fromJson(response.getEntity(String.class), JsonObject.class);

            return new Gson().fromJson(jo, new TypeToken<Token>() {}.getType());
			// erro de autenticação.
        } else if (response.getStatus() == 401) {
            return null;
			// erro geral.
        } else {
            return null;
        }
    }

    private String getUsuarioJson(String login, String senha) {
		JsonObject jo = new JsonObject();
		jo.addProperty("login", login);
		jo.addProperty("senha", senha);

		return new Gson().toJson(jo, JsonObject.class);
	}

}
