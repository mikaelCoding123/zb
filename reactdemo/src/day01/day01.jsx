import React, {Component} from 'react';
import api from "../api";

class Day01 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: "hua",
            data: new Date().toLocaleDateString(),
        }
    }


    render() {
        return (
            <div>
                <p>{this.state.name}</p>
                <button onClick={this.onclick01}>click01</button>
                <br/>
                <p>当前时间{new Date().toLocaleDateString()}</p>
            </div>
        );
    };

    onclick01 = (e) => {
        // let url = "https://www.fastmock.site/mock/f21700fa5f6d8dd8a4fb9e8838967e8f/react"
        // axios.get(url + "/getInfo").then(response => {
        //     console.log(response.data.name)
        // })
        api.get("http://localhost:8080/dev/bw/sz.do").then(res => {
            console.log(res)
        })
    };
}


export default Day01;