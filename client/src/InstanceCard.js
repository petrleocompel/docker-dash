import React, {Component} from "react"
import PropTypes from 'prop-types'
import {mapToCssModules} from 'reactstrap/lib/utils'
import {ButtonDropdown, ButtonGroup, Card, CardBlock, DropdownItem, DropdownMenu, DropdownToggle} from 'reactstrap'
import Link from "react-router-dom/es/Link";


const propTypes = {
    header: PropTypes.string,
    mainText: PropTypes.string,
    smallText: PropTypes.string,
    statusColor: PropTypes.string,
    start: PropTypes.function,
    stop: PropTypes.function,
    restart: PropTypes.function,
    del: PropTypes.function,
    key: PropTypes.string,
    instanceId: PropTypes.string,

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

    test() {
        this.props.start();
        this.props.rel();
    }


    render() {

        const{header, mainText, smallText, start, stop, restart, del, statusColor, key, instanceId} = this.props;


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
                                <DropdownItem onClick={start}>Start</DropdownItem>
                                <DropdownItem onClick={stop}>Stop</DropdownItem>
                                <DropdownItem onClick={restart}>Restart</DropdownItem>
                                <DropdownItem onClick={del}>Delete</DropdownItem>
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