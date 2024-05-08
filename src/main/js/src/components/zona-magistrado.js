import React, { useState, useEffect, useRef } from 'react';
import { Component } from 'react';
import { DataTable } from 'primereact/datatable';
import { Dropdown } from 'primereact/dropdown'
import { Column } from 'primereact/column';
import { MunicipioZonaDataService } from '../service/municipio_zona.service';
import { MagistradoDataService } from '../service/MagistradoService';
import { ProgressBar } from 'primereact/progressbar';
import { TabMenu } from 'primereact/tabmenu';
import { Card } from 'primereact/card';
import { ContextMenu } from 'primereact/contextmenu';
import { Toast } from 'primereact/toast';
import { Dialog } from 'primereact/dialog';
import { InputText } from "primereact/inputtext";
import { Button } from 'primereact/button';
import FormMagistrado from "./magistrado";
import Magistrados from './magistrados';

//toast = useRef(null);

export default class ZonaMagistrados extends Component {
    constructor(props) {
        super();
        this.retrieveMunicipios = this.retrieveMunicipios.bind(this);
        this.retrieveZonas = this.retrieveZonas.bind(this);
        this.retrieveMagistrados = this.retrieveMagistrados.bind(this);
        //this.setLoginVisible = this.setLoginVisible.bind(this);
        this.state = {
            municipios: [],
            zonas: [],
            magistrados: [],
            loginVisible: false,
            selectedMag: ''
        };
        this.toast = React.createRef();
        this.cm = React.createRef();
        this.selectedMag = null;
    }

    loading = false;
    setSelectedMag(mag) {
        this.selectedMag = mag;
        
    }
    viewMag = async (mag) => {
        await this.setState({ loginVisible: true, selectedMag: mag });
        this.toast.current.show({ severity: 'info', summary: 'Teste' + this.state.loginVisible, detail: mag.nome });
        /*this.setState({
            
        }, () => { this.setLoginVisible(true) });*/
    }
    items = [
        { label: 'Regulus v0.2.0 beta', icon: 'pi pi-fw pi-home' },
        /*{label: 'Calendar', icon: 'pi pi-fw pi-calendar'},
        {label: 'Edit', icon: 'pi pi-fw pi-pencil'},
        {label: 'Documentation', icon: 'pi pi-fw pi-file'},
        {label: 'Settings', icon: 'pi pi-fw pi-cog'}*/
    ]
    menuModel = [
        { label: 'View', icon: 'pi pi-fw pi-search', command: () => this.viewMag(this.selectedMag) }
        //{ label: 'Delete', icon: 'pi pi-fw pi-times', command: () => deleteProduct(selectedProduct) }
    ];
    setLoginVisible = (visible) => {
        this.setState({ loginVisible: false });
    }
    componentDidMount() {
        this.retrieveZonas();
        this.retrieveMunicipios();
        //this.updateZonas();
    }
    updateZonas() {
        let items = this.state.zonas;
        //console.log(items.length);
        items.forEach((zona, index) => {
            //zona.LABEL = zona.NUMERO + " - " + zona.SEDE;
            zona.LABEL = zona.id + " - " + zona.sede.nome;
        });
        this.loading = false
    }
    retrieveZonas() {
        this.loading = true;
        MunicipioZonaDataService.getAllZonas()
            .then(response => {
                this.setState({
                    zonas: response.data
                }, () => { this.updateZonas(); });
            })
            .catch(e => {
                console.log(e);
            });
    }
    retrieveMunicipios() {
        MunicipioZonaDataService.getAllMunicipios()
            .then(response => {
                this.setState({
                    municipios: response.data
                });
                //console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    retrieveMagistrados(sede) {
        this.loading = true;
        this.forceUpdate();
        MunicipioZonaDataService.getAllMagistradosZona(sede)
            .then(response => {
                this.setState({
                    magistrados: response.data
                }, () => { this.updateMagistrados() });
            })
            .catch(e => {
                console.log(e);
            });
    }

    updateMagistrados() {
        let items = this.state.magistrados;
        //console.log(items.length);
        items.forEach((mag, index) => {
            //console.log(mag.dias_sem_mandato + 1);
            mag.comEleitoral = (mag.diasSemMandato == 0 ? "SIM" : "NÃO");
            if (mag.diasSemMandato == 100000)
                mag.diasSemMandato = '';
            //console.log(mag.com_eleitoral);
        });
        this.loading = false;
        this.forceUpdate();
    }
    setMunicipio(valor) {
        //alert(this.state.selectedMunicipio);
        //alert(valor);
        this.setState({ selectedZona: valor });
        this.retrieveMagistrados(valor.sede.nome);
    }

    rowClassName(data) {
        return data.comEleitoral == 'SIM' ? 'destaqueRowColor' : '';
    }
    async enviarEmail(e) {
        e.preventDefault();
        try {
            MagistradoDataService.sendMailIndicacao(123456);
            //const token = await DataService.autenticar(login, senha);
            //doLogin(token);
            //this.toast.current.show({ severity: 'info', summary: 'Enviado!', detail: "Enviado com sucesso!" });
        } catch (err) {
            this.toast.current.show({ severity: 'error', summary: 'Erro ao enviar email', detail: "Erro ao tentar enviar e-mail" });
            console.log(err);
        }
        
        return;
    }
    nomeTemplate = (mag) => {
        this.selectedMag = mag;
        return (
            <div className="flex align-items-center gap-2">
                <Button icon="pi pi-send" 
                rounded outlined aria-label="Enviar e-mail" 
                onClick={() => this.viewMag(mag)}
                disabled={mag.comEleitoral == 'SIM'}/>
                <span>{mag.nome}</span>
            </div>
        );
    }
    render() {
        return (

            <div className="card justify-content-center">
                <Dialog header="Digite suas credencias" visible={this.state.loginVisible} style={{ width: '50vw' }} onHide={() => this.setLoginVisible(false)}>
                    <div className="flex flex-column gap-2">
                        <label htmlFor="username">Enviar e-mail para:</label>
                        <InputText id="magistrado" value={this.state.selectedMag.nome} disabled/>
                    </div>
                    <div className="flex flex-column gap-2">
                        <label htmlFor="username">Usuário:</label>
                        <InputText id="username" />
                    </div>
                    <div className="flex flex-column gap-2">
                        <label htmlFor="password">Senha:</label>
                        <InputText id="password" />
                    </div>
                    <Button label="Show" icon="pi pi-send" onClick={this.enviarEmail} />
                </Dialog>


                <Toast ref={this.toast} />
                <ContextMenu model={this.menuModel} ref={this.cm} onHide={() => this.setSelectedMag(null)} />
                <TabMenu model={this.items} />
                <Card title="Zona">
                    <Dropdown options={this.state.zonas} inputId='zona'
                        optionLabel="LABEL"
                        onChange={(e) => this.setMunicipio(e.value)}
                        placeholder="Escolha uma zona" className="w-full md:w-14rem"
                        value={this.state.selectedZona} filter />
                </Card>
                <ProgressBar hidden={!this.loading} mode="indeterminate" style={{ height: '6px' }}></ProgressBar>
                <Card title="Magistrados">
                    <div className="card">
                        <DataTable value={this.state.magistrados} tableStyle={{ minWidth: '50rem' }} rows={20}
                            rowClassName={this.rowClassName} paginator
                            onContextMenu={(e) => this.cm.current.show(e.originalEvent)}
                            contextMenuSelection={this.selectedMag}
                            onContextMenuSelectionChange={(e) => this.setSelectedMag(e.value)}>
                            <Column field="nome" sortable header="Nome" body={this.nomeTemplate}></Column>
                            <Column field="comarca.nome" sortable header="Comarca"></Column>
                            <Column field="distanciaZona" sortable header="Distância(km)"></Column>
                            <Column field="comEleitoral" sortable header="Com eleitoral?"></Column>
                            <Column field="diasSemMandato" sortable header="Dias sem eleitoral"></Column>
                        </DataTable>
                    </div>
                </Card>
            </div>
        );
    }


}

//export default App;