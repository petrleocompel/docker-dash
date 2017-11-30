import React from 'react'
import {responsr, instance, instanceStart, instanceStop, instanceRestart, instanceDelete} from "../api";
import Loader from "../Loader";
import {Button, Card, CardSubtitle, CardText, CardTitle, Col, Row} from "reactstrap";
import PropTypes from 'prop-types'


Card.propTypes = {
    // Pass in a Component to override default element
    tag: PropTypes.oneOfType([PropTypes.func, PropTypes.string]),
    inverse: PropTypes.bool,
    color: PropTypes.string,
    body: PropTypes.bool,
    className: PropTypes.string
};

class InstanceDetail extends React.Component {

    state = {instance: null};


    componentDidMount() {

        const {match: {params}} = this.props;


        responsr(instance(params.dockerId)).then((data) => {
            this.setState({instance: data});

            console.log(this.state.instance)
        })
    }
//TODO vzhled
    render() {

        if (!this.state.instance) {
            return <Loader/>

        }

        return (
            <Col xs="9" sm="6">
                <Card>
                    <CardTitle >Name: {this.state.instance.name}</CardTitle>
                    <CardSubtitle>Status: {this.state.instance.status}</CardSubtitle>
                    <CardText>
                        <Row><Col>Instance id: {this.state.instance.id}</Col></Row>
                        <Row><Col>Instance image: {this.state.instance.image}</Col></Row>
                        <Row><Col>Created: {this.state.instance.created}</Col></Row>
                        <Row><Col>Path: {this.state.instance.HostnamePath}</Col></Row>
                        <Row><Col>Domain name: {this.state.instance.Domainname}</Col></Row>
                        <Row>
                            <Col align="center">
                                <Button onClick={instanceStart(this.state.instance.id)} color="success">Start</Button>{' '}
                                <Button onClick={instanceStop(this.state.instance.id)} color="danger">Stop</Button>{' '}
                                <Button onClick={instanceRestart(this.state.instance.id)} color="warning">Restart</Button>{' '}
                                <Button onClick={instanceDelete(this.state.instance.id)} color="secondary">Delete</Button>
                            </Col>

                        </Row>
                    </CardText>
                </Card>
            </Col>
        );


    }
}


export default InstanceDetail;