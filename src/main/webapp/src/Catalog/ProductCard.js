import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import './ProductCard.css';
import shoppingCart from '../westCoastImg/shoppingCart.png';
import PropTypes from 'prop-types';

export default class ProductCard extends Component {
  render() {
    // Описание карточки товара
    const productItems = this.props.products.map((product) => (
      <Card bg="white" border="secondary" key={product.id}>
        <Link to={`/product/${product.id}`}>
          {product.images.length > 0 && (
            <Card.Img
              variant="top"
              src={`/images/${product.images[0]?.id}`}
            ></Card.Img>
          )}
        </Link>
        <Card.Body>
          <Link className="Card-Name p-0 m-0" to={`/product/${product.id}`}>
            <Card.Title style={{ fontSize: '26px' }}>{product.name}</Card.Title>
          </Link>
          <Card.Text className="Card-Price pt-2" style={{ fontSize: '20px' }}>
            <b>{product.price} ₽</b>
          </Card.Text>
          <div className="pt-2 m-0" style={{ textAlign: 'center' }}>
            <Button variant="secondary" id="addcart">
              <img
                src={shoppingCart}
                alt="shopping_cart"
                style={{ width: '20%' }}
              />
              <b> В корзину</b>
            </Button>
          </div>
        </Card.Body>
      </Card>
    ));
    return <>{productItems}</>;
  }
}

ProductCard.propTypes = {
  products: PropTypes.string,
};
