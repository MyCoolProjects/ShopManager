import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import './ProductCard.css';
import shoppingCart from '../westCoastImg/shoppingCart.png';
export default class ProductCard extends Component {

  render() {
    // const Star = ({ marked, starId }) => (
    //   <span className="Card-rating" star-id={starId} role="button">
    //     {marked ? "\u2605" : "\u2606"}
    //   </span>

    // );
    // возвращает рейтинг товара относительно параметра {product.reating}
    // const StarRating = props => {
    //   const [rating] = React.useState(
    //     typeof props.rating == "number" ? props.rating : 0
    //   );
    //   const [selection] = React.useState(0);

    //   return (
    //     <div>
    //       {Array.from({ length: 5 }, (v, i) => (
    //         <Star
    //           starId={i + 1}
    //           key={`star_${i + 1} `}
    //           marked={selection ? selection >= i + 1 : rating >= i + 1}
    //         />
    //       ))}
    //     </div>
    //   );
    // };

    // Описани карточки товара
    const productItems = this.props.products.map(product => (

      <Card bg="white" border="secondary" key={product.id} >
        <Link to={`/product/${product.id}`}>
          {product.images.length > 0 && <Card.Img variant="top" src={`/image/${product.images[0]?.id}`} alt="RobertPattison"></Card.Img>}
        </Link>
        <Card.Body>
          <Link className="Card-Name p-0 m-0" to={`/product/${product.id}`}>
            <Card.Title style={{ fontSize: '26px' }}>{product.name}</Card.Title>
          </Link>
          <Card.Text className="Card-Price pt-2" style={{ fontSize: '20px' }}>
            {/* <div><StarRating rating={product.reating} /></div> */}
            <b>{product.price} ₽</b>
          </Card.Text>
          <div className="pt-2 m-0" style={{ textAlign: 'center' }}>
            <Button variant="secondary" id="addcart" ><img src={shoppingCart} alt="sopping_cart" style={{ width: '20%' }} /><b> В корзину</b></Button>
          </div>
        </Card.Body>
      </Card >
    ));
    return (
      <>
        {productItems}
      </>
    );
  }
}