import React, {Component} from 'react'
import Loader from '../Loader'
import {getAll} from '../api'
import {Col, Row} from "reactstrap";
import ServiceCard from "../ServiceCard";

const Fragment = React.Fragment;

class Dashboard extends React.Component {

    state = {
        environments: null
    };

    componentDidMount() {
        this.fetchAll();
    }

    fetchAll = () => {
        getAll().then((data) => {
            this.setState({data});


        })
    }

    render() {


        if (!this.state.data) {
            return <Loader/>

        }

        return (
            <Fragment>

                <Row> {this.state.data.environments.map((item, index) => {


                    return (<Col xs="6" sm="12" key={index}>
                            <ServiceCard
                                name={item.image}
                                instances={item.services}
                                fetchAll={this.fetchAll}
                            />
                        </Col>

                    )
                })}
                </Row>
                <Row>
                    <Col>
                        <h2>Others</h2>
                        <ServiceCard
                            name="others"
                            instances={this.state.data.others}
                            fetchAll={this.fetchAll}
                        />
                    </Col>
                </Row>
            </Fragment>

        )
    }
}

export default Dashboard;
