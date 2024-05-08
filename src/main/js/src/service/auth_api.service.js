import { seguranca } from "../http-common";

export const AuthDataService = {
    async autenticar(login, senha) {
        let token = "";
        try {
            const response = await seguranca.post("/login", { login: login, senha: senha });
            token = response.data.valor;
            console.log(token);
            //login(response.data.token);
            //this.props.history.push("/app");
        } catch (err) {
            console.log("erro: "+err);
        }
        //seguranca.post("/autenticar", { login: login, senha: senha });
        return token;
    }
};