import React, {Component} from 'react'
import {responsr, getAll, instanceStop, instanceRestart, instanceStart} from '../api'
import {Col, Table} from 'reactstrap'
import Loader from '../Loader'
import Cards from '../Cards'


class Dashboard extends Component {
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
        instanceStart(id)
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
            this.state.images.map((item, index) => {
                return <Col xs="6"
                            sm="4"
                            tag={Cards}
                            key={index}
                            color="success"
                            header={item.name}
                            mainText={item.image}
                            variant="inverse"
                            smallText={item.status}
                            start={() => this.props.dispatch(this.handleStart(item.id))}
                            stop={() => this.props.dispatch(this.handleStop(item.id))}
                            restart={() => this.props.dispatch(this.handleRestart(item.id))}

                />
            })
        )
    }
}

export default Dashboard;
