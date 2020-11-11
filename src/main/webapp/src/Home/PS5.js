import React, { Component } from 'react';
import { Card } from 'react-bootstrap';
export default class FamousCategory extends Component {
    render() {
        return (
            <Card className="mt-5" fluid>
                <Card.Img src="https://i0.wp.com/itc.ua/wp-content/uploads/2020/08/screen_shot_2020_08_26_at_5.29.22_pm.0.png" alt="PS5 image" />
                <Card.ImgOverlay>
                    <Card.Title className="text-center"><h3>СКОРО В ПРОДАЖЕ</h3></Card.Title>
                </Card.ImgOverlay>
            </Card>
        )
    }
}