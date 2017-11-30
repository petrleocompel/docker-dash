import React, {Component} from 'react'
import InstanceCard from "../InstanceCard";
import Loader from '../Loader'
import {responsr, getAll, instanceStop, instanceRestart, instanceStart, instanceDelete} from '../api'
import {Col, Row} from "reactstrap";
import {Link} from 'react-router-dom';



class Dashboard extends React.Component {

    state = {images: null};

    componentDidMount() {
        responsr(getAll()).then((data) => {
            this.setState({images: data.others});


        })
    }

    handleStop = (id) => {
        instanceStop(id);
    };

    handleStart = (id) => {
        instanceStart(id);
    };

    handleRestart = (id) => {
        instanceRestart(id);
    };

    handleDelete = (id) => {
        instanceDelete(id);
    };

    handleList = (id) => {
        alert('Listing item TODO')
    };

    render() {


        if (!this.state.images) {
            return <Loader/>

        }

        return (
            <Row> {this.state.images.map((item, index) => {


                let status;

                if (item.status.indexOf("Up") !== -1) {
                    status = 'success';
                }
                else if (item.status.indexOf("Exited") !== -1) {
                    status = 'danger';
                }
                return <Col xs="6" sm="4">
                    <InstanceCard
                        key={index}
                        statusColor={status}
                        header={item.name}
                        mainText={item.image}
                        smallText={item.status}
                        start={() => this.props.dispatch(this.handleStart(item.id))}
                        stop={() => this.props.dispatch(this.handleStop(item.id))}
                        restart={() => this.props.dispatch(this.handleRestart(item.id))}
                        del={() => this.props.dispatch(this.handleDelete(item.id))}
                        instanceId={item.id}
                    /></Col>


            })}
            </Row>)

    }
}

export default Dashboard;
