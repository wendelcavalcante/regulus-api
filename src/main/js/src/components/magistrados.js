import React from "react";
import { Component } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { MagistradoDataService } from "../service/MagistradoService";
import { ProgressBar } from "primereact/progressbar";
import { Card } from "primereact/card";
import { Dialog } from "primereact/dialog";
import FormMagistrado from "./magistrado";
import { Button } from "primereact/button";

export default class Magistrados extends Component {
    constructor(props) {
        super();
        this.retrieveMagistrados = this.retrieveMagistrados.bind(this);
        this.state = {
            magistrados: [],
            magVisible: false,
            selectedMag: null,
        };
    }

    loading = false;

    viewMag = async (mag) => {
            await this.setState({ magVisible: true, selectedMag: mag });
            //this.toast.current.show({ severity: 'info', summary: 'Teste' + this.state.loginVisible, detail: mag.nome });
            /*this.setState({
    
            }, () => { this.setLoginVisible(true) });*/
    }
    

    componentDidMount() {
        this.retrieveMagistrados();
    }

    retrieveMagistrados() {
        this.loading = true;
        
        MagistradoDataService.getAllMagistrados()
            .then(response => {
                this.setState({
                    magistrados: response.data
                });
            })
            .catch(e => {
                console.log(e);
            })
    }

    magTemplate = (mag) => {
        //this.selectedMag = mag;
        return (
            <div className="flex align-items-center gap-2">
                <Button icon="pi pi-user"
                rounded outlined aria-label="Editar"
                onClick={() => this.viewMag(mag)}
                />
                <span></span>                
            </div>
        );
    }

    render() {
        return (
            <div className="card justify-content-center">
                <Dialog header="" visible={this.state.magVisible} style={{ width: '30vw' }} onHide={() => this.setState({ magVisible: false })}>
                    <FormMagistrado mag={this.state.selectedMag}></FormMagistrado>
                </Dialog>                
                <Card title="Magistrados">
                    <DataTable value={this.state.magistrados}
                        rows={20}
                        paginator
                    >
                        <Column header="" body={this.magTemplate}></Column>
                        <Column field="id" header="Id"></Column>
                        <Column field="matricula" header="Matrícula"></Column>
                        <Column field="nome" header="Nome"></Column>
                        <Column field="email" header="E-mail"></Column>
                    </DataTable>
                </Card>
            </div>
        );
    }
}