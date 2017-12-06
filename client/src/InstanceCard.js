import React, {Component} from "react"
import PropTypes from 'prop-types'
import {ButtonDropdown, ButtonGroup, Card, CardBlock, DropdownItem, DropdownMenu, DropdownToggle} from 'reactstrap'
import Link from "react-router-dom/es/Link";
import {instanceStop, instanceRestart, instanceStart, instanceDelete} from './api'


const propTypes = {
    header: PropTypes.string,
    mainText: PropTypes.string,
    smallText: PropTypes.string,
    statusColor: PropTypes.string,
    key: PropTypes.string,
    instanceId: PropTypes.string,
    fetchAll: PropTypes.func,

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


    handleStop = (id) => {
        instanceStop(id).then(() => {this.props.fetchAll()});

    };

    handleStart = (id) => {
        instanceStart(id).then(() => {this.props.fetchAll()});
    };

    handleRestart = (id) => {
        instanceRestart(id).then(() => {this.props.fetchAll()});
    };

    handleDelete = (id) => {
        instanceDelete(id).then(() => {this.props.fetchAll()});
    };


    render() {

        const{header, mainText, smallText, statusColor, key, instanceId} = this.props;


        return (
            <Card className={"text-white bg-" + statusColor}>
                <CardBlock className="card-body pb-0">
                    <ButtonGroup className="float-right">
                        <ButtonDropdown id={key} isOpen={this.state.card1}
                                        toggle={() => {
                                            this.setState({card1: !this.state.card1});
                                        }}>
                            <DropdownToggle caret className="p-0" color="transparent">
                                <i className="icon-settings"></i>
                            </DropdownToggle>
                            <DropdownMenu className={this.state.card1 ? "show" : ""} right>
                                <DropdownItem onClick={this.handleStart(instanceId)}>Start</DropdownItem>
                                <DropdownItem onClick={this.handleStop(instanceId)}>Stop</DropdownItem>
                                <DropdownItem onClick={this.handleRestart(instanceId)}>Restart</DropdownItem>
                                <DropdownItem onClick={this.handleDelete(instanceId)}>Delete</DropdownItem>
                            </DropdownMenu>
                        </ButtonDropdown>
                    </ButtonGroup>
                    <Link to={`/instance/${instanceId}`}><div className="h4 m-0">{header}</div></Link>
                    <div>{mainText}</div>
                    <small className="text-muted">{smallText}</small>
                </CardBlock>
            </Card>

        )
    }

}

InstanceCard.propTypes = propTypes;
InstanceCard.defaultProps = defaultProps;

export default InstanceCard;