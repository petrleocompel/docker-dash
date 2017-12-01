import React, {Component} from 'react'
import InstanceCard from "../InstanceCard";
import Loader from '../Loader'
import {responsr, getAll, instanceStop, instanceRestart, instanceStart, instanceDelete} from '../api'
import {Col, Row} from "reactstrap";


class Dashboard extends React.Component {

    state = {others: null};

    fetchData(){
        getAll().then((data) => {
            this.setState({others: data.others});


        })
    }

    componentDidMount() {
        this.fetchData();
    }

    handleStop = (id) => {
        instanceStop(id).then(() => {this.fetchData()});

    };

    handleStart = (id) => {
        instanceStart(id).then(() => {this.fetchData()});
    };

    handleRestart = (id) => {
        instanceRestart(id).then(() => {this.fetchData()});
    };

    handleDelete = (id) => {
        instanceDelete(id).then(() => {this.fetchData()});
    };


    render() {


        if (!this.state.others) {
            return <Loader/>

        }

        return (
            <Row> {this.state.others.map((item, index) => {


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
