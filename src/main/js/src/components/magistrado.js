import { Component } from 'react';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { Card } from 'primereact/card';
import { Button } from 'primereact/button';
import { MagistradoDataService } from '../service/MagistradoService';
import { Toast } from 'primereact/toast';
import React from 'react';

export default class FormMagistrado extends Component {
    constructor(props) {
        super();
        this.state = {
            id: props.mag.id,
            mag: props.mag,
            matricula: props.mag.matricula,
            nome: props.mag.nome,
            email: props.mag.email,
            comarca: props.mag.comarca.nome
        };
        console.log("id: " + props.mag.id);
        this.toast = React.createRef();
    }
    
    handleUpdate = async (e) => {
        //const { login, senha } = this.state;
        e.preventDefault();
        try {
            let magistrado = {
                id: this.state.id,
                matricula: this.state.matricula,
                nome: this.state.nome
            };
            MagistradoDataService.updateMagistrado(magistrado);
            this.state.mag.nome = this.state.nome;
            //const token = await DataService.autenticar(login, senha);
            //doLogin(token);
            this.toast.current.show({ severity: 'info', summary: 'Autenticado!', detail: "Salvo com sucesso!" });
        } catch (err) {
            this.toast.current.show({ severity: 'error', summary: 'Erro ao autenticar', detail: "Erro ao tentar salvar" });
            console.log(err);
        }
    };

    render() {
        return (
            <div className="card flex justify-content-center">
                <Toast ref={this.toast} />
                <Card title="Magistrado">
                    <form className="flex flex-column gap-3">
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <span>
                                            <div><label htmlFor="matricula">Matrícula</label></div>
                                            <InputText id="matricula" value={this.state.matricula} onChange={e => this.setState({ matricula: e.target.value })} size={15} />
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td colSpan={2}>
                                        <span>
                                            <div><label htmlFor="nome">Nome</label></div>
                                            <InputText id="nome" value={this.state.nome} onChange={e => this.setState({ nome: e.target.value })} size={50} />
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>
                                            <div><label htmlFor="email">Email</label></div>
                                            <InputText id="email" value={this.state.email} onChange={e => this.setState({ nome: e.target.value })} />
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            <div><label htmlFor="telefone">Telefone</label></div>
                                            <InputText id="telefone" onChange={e => this.setState({ nome: e.target.value })} />
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span>
                                            <div><label htmlFor="comarca">Comarca</label></div>
                                            <InputText id="comarca" value={this.state.comarca} onChange={e => this.setState({ nome: e.target.value })} />
                                        </span>
                                    </td>
                                    <td>
                                        <span>
                                            <div><label htmlFor="vara">Vara</label></div>
                                            <InputText id="vara" onChange={e => this.setState({ nome: e.target.value })} />
                                        </span>
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <span>
                            <Button label="Salvar" onClick={this.handleUpdate} />
                        </span>

                    </form>
                </Card>
            </div>
        )
    }
}