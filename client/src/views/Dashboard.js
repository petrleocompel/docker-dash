import React, {Component} from 'react'
import {responsr, getAll, instanceStop, instanceRestart, instanceStart} from '../api'
import {Table} from 'reactstrap'
import Loader from '../Loader'
import {Button} from 'reactstrap'
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
            this.state.images.map((item, index) =>{
              return <Cards key={index} color="success" header={item.id} mainText={item.image} variant="inverse" smallText={item.status}
              />
        })
            /*
            <Table inverse>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Mountpoint</th>
                    <th>Status</th>
                    <th>Actions</th>
                    <th>Image name</th>
                </tr>
                </thead>
                <tbody>
                {this.state.images.map((item, index) => {
                    return <tr key={index}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.mountpoint}</td>
                        <td>{item.status}</td>
                        <td>
                            <div>
                                <Button outline color="info"
                                        onClick={() => this.handleList(item.id)}>List</Button>{' '}
                                <Button outline color="success"
                                        onClick={() => this.handleStart(item.id)}>Start</Button>{' '}
                                <Button outline color="danger"
                                        onClick={() => this.handleStop(item.id)}>Stop</Button>{' '}
                                <Button outline color="warning"
                                        onClick={() => this.handleRestart}>Restart</Button>{' '}
                            </div>
                        </td>
                        <td>{item.image}</td>
                    </tr>
                })}
                </tbody>
            </Table>*/
        )
    }
}

export default Dashboard;
