import React, {Component} from "react"
import PropTypes from 'prop-types'
import {ButtonDropdown, ButtonGroup, Card, CardBlock, DropdownItem, DropdownMenu, DropdownToggle} from 'reactstrap'
import Link from "react-router-dom/es/Link";
import {instanceStop, instanceRestart, instanceStart, instanceDelete} from './api'
import Loader from "./Loader";


class InstanceCard extends React.Component {

    static propTypes = {
        header: PropTypes.string,
        mainText: PropTypes.string,
        smallText: PropTypes.string,
        statusColor: PropTypes.string,
        key: PropTypes.string,
        instanceId: PropTypes.string,
        fetchAll: PropTypes.func,

    };

    static defaultProps = {
        header: '89.9%',
        mainText: 'Lorem ipsum...',
        smallText: 'Lorem ipsum dolor sit amet enim.',
        // color: '',
        value: "25",
        variant: ""
    };

    state = {
        loading: false,
        dropdownOpen: false
    };

    toggle = () => {
        this.setState((prevProps) => ({
            dropdownOpen: !prevProps.dropdownOpen
        }));
    };

    setLoading = (status) => {
        this.setState({loading: status});
    };


    handleStop = (id) => {
        this.setLoading(true);
        instanceStop(id).then(() => {
            this.setLoading(false);
            this.props.fetchAll()
        });

    };

    handleStart = (id) => {
        this.setLoading(true);
        instanceStart(id).then(() => {
            this.setLoading(false);
            this.props.fetchAll()
        });
    };

    handleRestart = (id) => {
        this.setLoading(true);
        instanceRestart(id).then(() => {
            this.setLoading(false);
            this.props.fetchAll()
        });
    };

    handleDelete = (id) => {
        this.setLoading(true);
        instanceDelete(id).then(() => {
            this.setLoading(false);
            this.props.fetchAll()
        });
    };


    render() {

        const{header, mainText, smallText, statusColor, key, instanceId} = this.props;

        return (
            <Card className={"text-white bg-" + statusColor}>
                <CardBlock className="card-body pb-0">
                    <ButtonGroup className="float-right">
                        {!this.state.loading ? <ButtonDropdown id={key} isOpen={this.state.dropdownOpen}
                                        toggle={this.toggle}>
                            <DropdownToggle caret className="p-0" color="transparent">
                                <i className="icon-settings"> </i>
                            </DropdownToggle>
                            <DropdownMenu className={this.state.dropdownOpen ? "show" : ""} right>
                                <DropdownItem onClick={() => this.handleStart(instanceId)}>Start</DropdownItem>
                                <DropdownItem onClick={() => this.handleStop(instanceId)}>Stop</DropdownItem>
                                <DropdownItem onClick={() => this.handleRestart(instanceId)}>Restart</DropdownItem>
                                <DropdownItem onClick={() => this.handleDelete(instanceId)}>Delete</DropdownItem>
                            </DropdownMenu>
                        </ButtonDropdown> : <Loader/>}
                    </ButtonGroup>
                    <Link to={`/instance/${instanceId}`} style={{color: 'white'}}><div className="h4 m-0">{header}</div></Link>
                    <div>{mainText}</div>
                    <small className="text-muted">{smallText}</small>
                </CardBlock>
            </Card>

        )
    }

}

export default InstanceCard;