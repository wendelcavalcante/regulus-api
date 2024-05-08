import { Component } from 'react';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { Card } from 'primereact/card';
import { AuthDataService } from '../service/auth_api.service';
import { doLogin } from '../service/auth';

export default class Login extends Component {
    state = {
        login: "",
        senha: "",
        error: ""
    };

    handleSignIn = async e => {
        e.preventDefault();
        const { login, senha } = this.state;
        if (!login || !senha) {
            this.setState({ error: "Preencha e-mail e senha para continuar!" });
        } else {
            try {
                //console.log("---" + login + " " + senha);
                const token = await AuthDataService.autenticar(login, senha);//await api.post("/sessions", { email, password });
                doLogin(token);
                //login(response.data.valor);
                //this.props.history.push("/app");
            } catch (err) {
                this.setState({
                    error:
                        "Houve um problema com o login, verifique suas credenciais. T.T"
                });
                console.log(err);
            }
        }
    };
    render() {
        return (
            <div className="card flex justify-content-center">
                <Card title="Login">
                    <form className="flex flex-column gap-2" onSubmit={this.handleSignIn}>
                        <span className="p-float-label">
                            <InputText id="login" onChange={e => this.setState({ login: e.target.value })}/>
                            <label htmlFor="login">Usuário</label>
                        </span>
                        <span className="p-float-label">
                            <Password id="senha" onChange={e => this.setState({ senha: e.target.value })}/>
                            <label htmlFor="senha">Senha</label>
                        </span>
                        <span>
                            <button type="submit">Entrar</button>
                        </span>

                    </form>
                </Card>
            </div>
        )
    }
}