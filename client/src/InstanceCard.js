import React, {Component} from "react"
import PropTypes from 'prop-types'
import {mapToCssModules} from 'reactstrap/lib/utils'
import {responsr, getAll, instanceStop, instanceRestart, instanceStart} from './api'
import {ButtonDropdown, ButtonGroup, Card, CardBlock, Col, DropdownItem, DropdownMenu, DropdownToggle,Row} from 'reactstrap'
import Loader from './Loader'

const propTypes = {
    header: PropTypes.string,
    mainText: PropTypes.string,
    smallText: PropTypes.string,
    color: PropTypes.string,
    value: PropTypes.string,
    children: PropTypes.node,
    className: PropTypes.string,
    cssModule: PropTypes.object,
    variant: PropTypes.string
};

const defaultProps = {
    header: '89.9%',
    mainText: 'Lorem ipsum...',
    smallText: 'Lorem ipsum dolor sit amet enim.',
    // color: '',
    value: "25",
    variant: ""
};

class InstanceCard extends React.Component {

    state = {images: null};

    constructor(props) {
        super(props);

        this.toggle = this.toggle.bind(this);
        this.state = {
            dropdownOpen: false
        };
    }

    toggle() {
        this.setState({
            dropdownOpen: !this.state.dropdownOpen
        });
    }

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

    handleList = (id) => {
        alert('Listing item TODO')
    };


    render() {
        if (!this.state.images) {
            return <Loader/>

        }

        return (
            <Row> { this.state.images.map((item, index) => {


                let statusColor;

                if (item.status.indexOf("Up") !== -1) {
                    statusColor = 'success';
                }
                else if(item.status.indexOf("Exited") !== -1){
                    statusColor = 'danger';
                }
                return <Col key={index} xs="6" sm="4">
                    <Card className={"text-white bg-" + statusColor}>
                        <CardBlock className="card-body pb-0">
                            <ButtonGroup className="float-right">
                                <ButtonDropdown id={index} isOpen={this.state.card1}
                                                toggle={() => {
                                                    this.setState({card1: !this.state.card1});
                                                }}>
                                    <DropdownToggle  caret className="p-0" color="transparent">
                                        <i className="icon-settings"></i>
                                    </DropdownToggle>
                                    <DropdownMenu className={this.state.card1 ? "show" : ""} right>
                                        <DropdownItem onClick={() => (this.handleStart(item.id))}>Start</DropdownItem>
                                        <DropdownItem onClick={() => (this.handleStop(item.id))}>Stop</DropdownItem>
                                        <DropdownItem onClick={() => (this.handleRestart(item.id))}>Restart</DropdownItem>
                                    </DropdownMenu>
                                </ButtonDropdown>
                            </ButtonGroup>
                            <div className="h4 m-0">{item.name}</div>
                            <div>{item.image}</div>
                            <small className="text-muted">{item.status}</small>
                        </CardBlock>
                    </Card>
                </Col>

            })}
            </Row>)
    }
}

InstanceCard.propTypes = propTypes;
InstanceCard.defaultProps = defaultProps;

export default InstanceCard;