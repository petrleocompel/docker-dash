import React, {Component} from 'react';
import {Link, Switch, Route, Redirect} from 'react-router-dom';
import {Container} from 'reactstrap';
import Header from '../../components/Header/';
import Sidebar from '../../components/Sidebar/';
import Breadcrumb from '../../components/Breadcrumb/';
import Aside from '../../components/Aside/';
import Footer from '../../components/Footer/';

import Dashboard from '../../views/Dashboard';
import Images from '../../views/Images';
import InstanceDetail from "../../views/InstanceDetail";

class Full extends Component {
    render() {
        return (
            <div className="app">
                <Header/>
                <div className="app-body">
                    <Sidebar {...this.props}/>
                    <main className="main">
                        <Breadcrumb/>
                        <Container fluid>
                            <Switch>
                                <Route path="/dashboard" name="Dashboard" component={Dashboard}/>
                                <Route path="/instance/:dockerId" component={InstanceDetail}/>

                                <Redirect from="/" to="/dashboard"/>

                            </Switch>
                        </Container>
                    </main>
                    <Aside/>
                </div>
                <Footer/>
            </div>
        );
    }
}

export default Full;
