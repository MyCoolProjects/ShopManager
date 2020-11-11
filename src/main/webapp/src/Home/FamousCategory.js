import React, { Component } from 'react';
import { Container, Card, CardDeck } from 'react-bootstrap';
import { Link } from 'react-router-dom';
export default class FamousCategory extends Component {
    render() {
        return (
            <Container fluid className="p-0 m-0 mt-5 mb-5" expand="md">
                <div><h3>ПОПУЛЯРНЫЕ КАТЕГОРИИ</h3></div>
                <CardDeck className="mt-3" fluid >
                    {/* border-0 */}

                    <Card bg="white border-0">
                        <Link to="/catalog">
                            <Card.Img
                                variant="top"
                                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                                // 700*900
                                src="https://items.s1.citilink.ru/1129835_v01_b.jpg"
                                alt="Smartphones">
                            </Card.Img>
                        </Link>
                    </Card>

                    <Card bg="white border-0">
                        <Link to="/catalog">
                            <Card.Img
                                variant="top"
                                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                                src="https://c.dns-shop.ru/thumb/st4/fit/800/650/5b1b7f06868dbb6c9df7e5604c2a04f2/3468acf9c94a7c8731b41886a717e0b471ac3f407d0aed6d8ee7aa0dd27e6212.jpg"
                                alt="Laptops">
                            </Card.Img>
                        </Link>
                    </Card>

                    <Card bg="white border-0">
                        <Link to="/catalog">
                            <Card.Img
                                variant="top"
                                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                                src="https://www.nvidia.com/content/dam/en-zz/Solutions/GeForce/campaigns/10-series/geforce-gtx-1080-ti-2c50-P@2x.png"
                                alt="Video cards">
                            </Card.Img>
                        </Link>
                    </Card>

                    <Card bg="white border-0">
                        <Link to="/catalog">
                            <Card.Img
                                variant="top"
                                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                                src="https://img.mvideo.ru/Pdb/small_pic/600/30043267b.jpg"
                                alt="Tablets">
                            </Card.Img>
                        </Link>
                    </Card>

                </CardDeck>


                <CardDeck fluid >

                    <Card bg="white border-0">
                        <Card.Body>
                            <Link className="Card-Name p-0 m-0" to="/catalog">
                                <Card.Title style={{ fontSize: "26px" }}><h3>СМАРТФОНЫ</h3></Card.Title>
                            </Link>
                        </Card.Body>
                    </Card>

                    <Card bg="white border-0">
                        <Card.Body>
                            <Link className="Card-Name p-0 m-0" to="/catalog">
                                <Card.Title style={{ fontSize: "26px" }}><h3>НОУТБУКИ</h3></Card.Title>
                            </Link>
                        </Card.Body>
                    </Card>

                    <Card bg="white border-0">
                        <Card.Body>
                            <Link className="Card-Name p-0 m-0" to="/catalog">
                                <Card.Title style={{ fontSize: "26px" }}><h3>ВИДЕОКАРТЫ</h3></Card.Title>
                            </Link>
                        </Card.Body>
                    </Card>

                    <Card bg="white border-0">
                        <Card.Body>
                            <Link className="Card-Name p-0 m-0" to="/catalog">
                                <Card.Title style={{ fontSize: "26px" }}><h3>ПЛАНШЕТЫ И ЭЛЕКТРОННЫЕ КНИГИ</h3></Card.Title>
                            </Link>
                        </Card.Body>
                    </Card>

                </CardDeck>
            </Container>
        )
    }
}