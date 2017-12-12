import React, {Component} from 'react'
import InstanceCard from "./InstanceCard";
import Loader from './Loader'
import {Col, Row} from "reactstrap";
import PropTypes from 'prop-types'


const propTypes = {
    name: PropTypes.string,
    instances: PropTypes.array,
    fetchAll: PropTypes.func

};


class ServiceCard extends React.Component {


    render() {

        if (!this.props.instances) {
            return <Loader/>

        }

        return (

            <Row><Col sm="12"><h2>{this.props.instances["0"].labels["com.docker.compose.service"]}</h2></Col> {this.props.instances.map((item, index) => {

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
                        instanceId={item.id}
                        fetchAll={this.props.fetchAll}
                    /></Col>


            })}
            </Row>)

    }
}
ServiceCard.propTypes = propTypes;

export default ServiceCard;
