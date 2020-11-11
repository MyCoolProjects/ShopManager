import React, { Component } from 'react';
import { Container, Row, Col, CardColumns, Form, Button, Spinner } from 'react-bootstrap';
// const Product_Card = lazy(() => import('./Product_Card.js'))
import ProductCard from './ProductCard.js';
import './ProductCard.css';

class ProductsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      products: []

    };
  }
  componentDidMount() {
    fetch('/api/product')
      .then(res => {
        if (!res.ok) throw new Error('Not 2xx response');
        return res;
      })
      .then(res => res.json())
      .then((result) => {
        if (!result) throw new Error('Empty response');
        this.setState({
          isLoaded: true,
          products: result.products
        });
      })
      .catch((error) => {
        this.setState({
          isLoaded: true,
          error
        });
      });
    // fetch("/Main.json")
    //   .then(res => res.json())
    //   .then(
    //     (result) => {
    //       this.setState({
    //         isLoaded: true,
    //         products: result.products
    //       });
    //     },
    //     (error) => {
    //       this.setState({
    //         isLoaded: true,
    //         error
    //       })
    //     }
    //   )

  }


  render() {


    const { error, isLoaded, products } = this.state;
    if (error) {
      return (
        <div>Error {error.message}</div>
      );
    }
    else if (!isLoaded) {
      return (
        <Container fluid className="mb-5 mt-5" style={{ textAlign: 'center', verticalAlign: 'middle', height: '757px', fontSize: 40 }}>
          <Button variant="dark" disabled>
            <Spinner
              as="span"
              animation="border"
              size=""
              role="status"
              aria-hidden="true"
            />
            {' '} Loading...
            </Button>
        </Container>
      );
    }
    else {
      return (
        <>
          <Container fluid className="pt-3">
            <Row>
              <Col sm={1}></Col>
              <Col sm={2} className="pl-5"> {/* катекогрии фильтры и прочее */}

                <Row><b>Категории:</b></Row>
                <Row className="pt-3 pb-5">
                  <Form.Group id="formGridCheckbox1">
                    <Form.Check type="checkbox" label="Check me out" />
                    <Form.Check type="checkbox" label="Check me out2" />
                    <Form.Check type="checkbox" label="Check me out3" />
                  </Form.Group>
                </Row>

                <Row><b>Бренд:</b></Row>
                <Row className="pt-3 pb-5">
                  <Form.Group id="formGridCheckbox2">
                    <Form.Check type="checkbox" label="Check me out" />
                    <Form.Check type="checkbox" label="Check me out2" />
                    <Form.Check type="checkbox" label="Check me out3" />
                  </Form.Group>
                </Row>

                <Row className="pb-5">
                  <Form>
                    <Form.Group controlId="formBasicRange">
                      <Form.Label><b>Цена:</b></Form.Label>
                      <Form.Control type="range" />
                    </Form.Group>
                  </Form>
                </Row>

                <Row><b>Рейтинг покупателей:</b></Row>
                <Row className="pt-3 pb-5">
                  <Form>
                    <Form.Group id="formGridRadio">
                      <Form.Check type="radio" label="radio 1" />
                      <Form.Check type="radio" label="radio 2" />
                      <Form.Check type="radio" label="radio 3" />
                    </Form.Group>
                  </Form>
                </Row>

              </Col>


              {/* катекогрии фильтры и прочее */}
              <Col sm={8} style={{ textAlign: 'end' }}>
                <Row>
                  <Col className="filter-2">
                    <select defaultValue="1" className="select-css">
                      <option value="0">Сначала дешевле</option>
                      <option value="1" >Сначала дороже</option>
                      <option value="2">Сначала с высоким рейтингом</option>
                      <option value="3">Сначала со скидкой</option>
                    </select>
                    <hr />
                  </Col>
                </Row>
                <Col sm={1}></Col>


                {/* список товаров */}
                <Row>
                  <Col>
                    <CardColumns className="space-behind-product-card">
                      <ProductCard products={products} />
                    </CardColumns>
                  </Col>
                </Row>

              </Col>
            </Row>
          </Container >
        </>
      );
    }
  }
}

export default ProductsList;
