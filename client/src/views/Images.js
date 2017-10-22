import React, {Component} from 'react'
import {responsr, getAll} from '../api'
import {Table} from 'reactstrap'
import Loader from '../Loader'
import { Button } from 'reactstrap'


class Images extends Component {
    state = {images: null};

    componentDidMount() {
        responsr(getAll()).then((data) => {
            this.setState({images: data});

        })
    }

    render() {
        if (!this.state.images) {
            return <Loader/>

        }

        return (
            <Table inverse>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Mountpoint</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {this.state.images.map((item, index) => {
                    return <tr>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.mountpoint}</td>
                        <td> <div>
                            <Button outline color="info">List</Button>{' '}
                            <Button outline color="success">Start</Button>{' '}
                            <Button outline color="danger">Stop</Button>{' '}
                            <Button outline color="warning">Restart</Button>{' '}
                        </div></td>
                    </tr>
                })}

                </tbody>
            </Table>
        )
    }
}

export default Images;
