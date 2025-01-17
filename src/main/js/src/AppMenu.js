
import React from 'react';
import { Menubar } from 'primereact/menubar';
import { InputText } from 'primereact/inputtext';
import ZonaMagistrados from './components/zona-magistrado'
import LoginForm from './components/login';
import Magistrado from './components/magistrado';
import Magistrados from './components/magistrados';
import { Routes, Route, Link } from "react-router-dom";
import { isAuthenticated } from './service/auth';

export default function TemplateDemo() {
    const items = [
        {
            label: 'Magistrados',
            icon: 'pi pi-fw pi-user',
            url: '/regulus/magistrados'
        },
        {
            label: 'Zonas - Magistrados',
            icon: 'pi pi-fw pi-building',
            url: '/regulus/zona_magistrados'
        },
        /*{
            label: 'File',
            icon: 'pi pi-fw pi-file',
            items: [
                {
                    label: 'New',
                    icon: 'pi pi-fw pi-plus',
                    items: [
                        {
                            label: 'Bookmark',
                            icon: 'pi pi-fw pi-bookmark'
                        },
                        {
                            label: 'Video',
                            icon: 'pi pi-fw pi-video'
                        },

                    ]
                },
                {
                    label: 'Delete',
                    icon: 'pi pi-fw pi-trash'
                },
                {
                    separator: true
                },
                {
                    label: 'Export',
                    icon: 'pi pi-fw pi-external-link'
                }
            ]
        },
        {
            label: 'Edit',
            icon: 'pi pi-fw pi-pencil',
            items: [
                {
                    label: 'Left',
                    icon: 'pi pi-fw pi-align-left'
                },
                {
                    label: 'Right',
                    icon: 'pi pi-fw pi-align-right'
                },
                {
                    label: 'Center',
                    icon: 'pi pi-fw pi-align-center'
                },
                {
                    label: 'Justify',
                    icon: 'pi pi-fw pi-align-justify'
                },

            ]
        },
        {
            label: 'Users',
            icon: 'pi pi-fw pi-user',
            items: [
                {
                    label: 'New',
                    icon: 'pi pi-fw pi-user-plus',

                },
                {
                    label: 'Delete',
                    icon: 'pi pi-fw pi-user-minus',

                },
                {
                    label: 'Search',
                    icon: 'pi pi-fw pi-users',
                    items: [
                        {
                            label: 'Filter',
                            icon: 'pi pi-fw pi-filter',
                            items: [
                                {
                                    label: 'Print',
                                    icon: 'pi pi-fw pi-print'
                                }
                            ]
                        },
                        {
                            icon: 'pi pi-fw pi-bars',
                            label: 'List'
                        }
                    ]
                }
            ]
        },
        {
            label: 'Events',
            icon: 'pi pi-fw pi-calendar',
            items: [
                {
                    label: 'Edit',
                    icon: 'pi pi-fw pi-pencil',
                    items: [
                        {
                            label: 'Save',
                            icon: 'pi pi-fw pi-calendar-plus'
                        },
                        {
                            label: 'Delete',
                            icon: 'pi pi-fw pi-calendar-minus'
                        }
                    ]
                },
                {
                    label: 'Archive',
                    icon: 'pi pi-fw pi-calendar-times',
                    items: [
                        {
                            label: 'Remove',
                            icon: 'pi pi-fw pi-calendar-minus'
                        }
                    ]
                }
            ]
        },*/
        {
            label: 'Login',
            icon: 'pi pi-fw pi-power-off',
            url: '/regulus/login'
        },
        {
            label: 'Acesso Magistrado',
            icon: 'pi pi-fw pi-power-off',
            url: '/regulus/login'
        },
        {
            label: 'Quit',
            icon: 'pi pi-fw pi-power-off',
            url: '/regulus/magistrados'
        },
        /*{
            template: (item, options) => {
                return (
                    <Link to={"/regulus/magistrados"} className="navbar-brand">
                        Zonas - Magistrados
                    </Link>
                )
            }
        }*/
    ];

    //const start = <img alt="logo" src="https://primefaces.org/cdn/primereact/images/logo.png" height="40" className="mr-2"></img>;
    const end = <InputText placeholder="Search" type="text" className="w-full" />;

    return (
        <div className="card">
            <Menubar model={items} end={end} /> 
            <Routes>
                <Route path='/regulus/zona_magistrados' Component={ZonaMagistrados} />
                <Route path='/regulus/magistrados' Component={Magistrados} />
                <Route path='/regulus/login' Component={LoginForm} />
                <Route path='/regulus/magistrado' Component={Magistrado} />
                <Route path="*" component={() => <h1>Page not found</h1>} />
            </Routes>
        </div>
    )
}
