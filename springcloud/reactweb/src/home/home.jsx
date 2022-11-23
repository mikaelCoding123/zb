import React, {Component} from 'react';

class Home extends Component {


    render() {
        return (
            <div>
                <canvas></canvas>
                <button onClick={this.anniu01}>按钮1</button>
            </div>
        );
    }

    anniu01 = (e) => {

        console.log("anniu01")
        window.location.href = "news"
    }


}

export default Home;