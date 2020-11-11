import React, { Component } from 'react'
import { Row, Col, Container, Button, Carousel, Image } from 'react-bootstrap';
import sopping_cart from '../westCoastImg/shoppingCart.png'
import './Product.css'
export default class Product extends Component {
  render() {
    const specificationsArray = this.props.currProduct.specifications.map(spec => (
      <>

        <Container fluid key={spec.id}>
          <Row className="pt-2 pb-1">
            <Col sm style={{ textAlign: "left" }}>
              <b>{spec.name}:</b>
            </Col>
            <Col sm style={{ textAlign: "right" }}>
              {spec.value}
            </Col>
          </Row>
          <hr className="p-0 m-0" />
        </Container>
      </>

    ))
    return (
      <>
        <Container fluid style={{ fontSize: 20 }} key={this.props.currProduct.id} expand="md">
          <Row className="mt-5">
            <Col sm={1}></Col>
            <Col sm={10}>
              <Row>
                <Col className="pl-5" >
                  {this.props.currProduct.name}
                </Col>
              </Row>
              <Row>
                <Col className="pl-5" style={{ textAlign: "left" }} >
                  <div><b>Тут будет рейтинг</b></div>
                </Col>
                <Col className="pr-5" style={{ textAlign: "right" }}>
                  <div>Код товара: {this.props.currProduct.id}</div>
                </Col>
              </Row>
              <hr color="red" />
              <Row>
                <Col sm={4}>
                  <Carousel className="carousel mt-3 mb-5" style={{ height: "600px" }}>
                    {this.props.currProduct.images.map(image => 
                      <Carousel.Item key={image.id} className="product-carousel-item" style={{ height: "600px" }}>
                      <Image
                        fluid
                        className="d-block"
                        style={{ position: "relative", objectFit: "cover", height: "600px" }}
                        src={`/image/${image.id}`}
                        alt="First slide"
                      />
                    </Carousel.Item>
                    )}
                  </Carousel>
                </Col>

                <Col sm={4} className="pl-5">
                  <Row className="pl-3 pb-5"><b>Характеристики:</b></Row>
                  <Row>{specificationsArray}</Row>
                </Col>

                <Col sm={4} className="pl-5">
                  <Row className="pl-3 pb-5"><b>Цена:</b></Row>
                  <Row className="pb-5">
                    <Col sm style={{ textAlign: "left" }}>
                      <b>{this.props.currProduct.price} ₽</b>
                      <hr className="mt-1 p-0 m-0" />
                    </Col>
                    <Col sm style={{ textAlign: "right" }}>
                      <Button variant="secondary" id="addcart" ><img src={sopping_cart} alt="sopping_cart" style={{ width: "20%" }} /><b> В корзину</b></Button>
                    </Col>
                  </Row>
                </Col>
              </Row>
              <hr color="red" />
            </Col>
            <Col sm={1}></Col>
          </Row>
        </Container>
      </>
    )
  }
}