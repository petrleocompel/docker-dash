import React from "react";
import FontAwesome from "react-fontawesome";

class Loader extends React.Component{

    render() {

        return(
            <FontAwesome name='spinner'
                         size='2x'
                         spin
                         style={{ textShadow: '0 1px 0 rgba(0, 0, 0, 0.1)' }}/>

        )
    }

}

export default Loader
