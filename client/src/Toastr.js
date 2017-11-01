import React, {Component} from 'react';
import {ToastContainer, toast} from 'react-toastify'
import 'react-toastify/dist/ReactToastify.min.css'

class Toastr extends React.Component{
    notify = () => toast.error("No data recieved!");
    render(){
        return (
                <ToastContainer
                    position="top-right"
                    type="error"
                    autoClose={5000}
                    hideProgressBar={false}
                    newestOnTop={false}
                    closeOnClick
                    pauseOnHover
                />

        );
    }

}

export default Toastr