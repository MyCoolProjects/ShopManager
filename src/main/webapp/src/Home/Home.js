import React, { Component } from 'react';
import { Container, Carousel, Image} from 'react-bootstrap';
import FamousCategory from './FamousCategory.js'
import PS5 from './PS5.js'
import './Home.css';
export default class Home extends Component {
  render() {
    return (
      <Container fluid style={{ fontSize: 20 }} key={this.props.id} expand="md">
        <Container>
          <div className="mt-5"></div>
          <Carousel variant="secondary">


            <Carousel.Item className="carousel-item" style={{ height: "600px" }}>
              <Image
                fluid
                className="d-block"
                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                src="https://www.apple.com/v/iphone-12-pro/a/images/meta/iphone-12-pro_overview__d5t6ow03nkmu_og.png"
                alt="1 slide"
              />
              <Carousel.Caption>
                <h3>iPhone 12 Pro</h3>
                <p>В продаже с 30 октября</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: "600px" }}>
              <Image
                fluid
                className="d-block"
                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                src="https://www.ixbt.com/img/n1/news/2020/3/1/432423423_large.jpg"
                alt="2 slide"
              />
              <Carousel.Caption className="home-list-carousel">
                <h3>Заголовок новости №2</h3>
                <p>Новость...</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: "600px" }}>
              <Image
                fluid
                className="d-block"
                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                src="https://mobile-review.com/articles/2020/image/iphone-12-presentation/scr-off/2.jpg"
                alt="3 slide"
              />
              <Carousel.Caption >
                <h3>Заголовок новости №3</h3>
                <p>Новость...</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: "600px" }}>
              <Image
                fluid
                className="d-block"
                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                src="https://www.ixbt.com/img/n1/news/2020/6/2/173400_O_large.jpg"
                alt="4 slide"
              />
              <Carousel.Caption >
                <h3>Заголовок новости №4</h3>
                <p>Новость...</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: "600px" }}>
              <Image
                fluid
                className="d-block"
                style={{ position: "center", objectFit: "cover", height: "100%", width: "100%" }}
                src="https://mobile-review.com/articles/2020/image/iphone-12-presentation/scr-off/4.jpg"
                alt="5 slide"
              />
              <Carousel.Caption>
                <h3>Заголовок новости №5</h3>
                <p>Новость...</p>
              </Carousel.Caption>
            </Carousel.Item>
          </Carousel>

          {/* РОФЛ с PS 5 можно спокойно удалить, потому что для нне придется создать отдельную категорию и прочее */}
          <PS5/>

          {/* Популярные категории */}
          <FamousCategory/>

        </Container>
      </Container>
    )
  }
}