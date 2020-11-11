import React, { Component } from 'react';
import { Container, Carousel, Image } from 'react-bootstrap';
import './Home.css';
export default class Home extends Component {
  render() {
    return (
      <Container fluid style={{ fontSize: 20 }} key={this.props.id} expand="md">
        <Container>
          <Carousel variant="secondary">


            <Carousel.Item className="carousel-item" style={{ height: '600px' }}>
              <Image
                fluid
                className="d-block"
                style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                src="https://www.apple.com/v/iphone-12-pro/a/images/meta/iphone-12-pro_overview__d5t6ow03nkmu_og.png"
                alt="1 slide"
              />
              <Carousel.Caption>
                <h3>iPhone 12 Pro</h3>
                <p>В продаже с 30 октября</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: '600px' }}>
              <Image
                fluid
                className="d-block"
                style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                src="https://www.ixbt.com/img/n1/news/2020/3/1/432423423_large.jpg"
                alt="2 slide"
              />
              <Carousel.Caption className="home-list-carousel">
                <h3>iPhone 12 Pro</h3>
                <ul style={{ textDecoration: 'none' }}>
                  <li>На <b>11%</b> тоньше, чем iPhone 11</li>
                  <li>На <b>15%</b> меньше, чем iPhone 11</li>
                  <li>На <b>16%</b> легче, чем iPhone 11</li>
                </ul>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: '600px' }}>
              <Image
                fluid
                className="d-block"
                style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                src="https://mobile-review.com/articles/2020/image/iphone-12-presentation/scr-off/2.jpg"
                alt="3 slide"
              />
              <Carousel.Caption >
                <h3>iPhone 12 Pro</h3>
                <p>Дисплей Super Retina XDR 6,1 дюйма</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: '600px' }}>
              <Image
                fluid
                className="d-block"
                style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                src="https://www.ixbt.com/img/n1/news/2020/6/2/173400_O_large.jpg"
                alt="4 slide"
              />
              <Carousel.Caption >
                <h3>iPhone 12 Pro</h3>
                <p>A14 Bionic, самый быстрый процессор iPhone. Полностью обновлённый дизайн. Передняя панель Ceramic Shield. Сканер LiDAR для улучшенной дополненной реальности. Система камер Pro, адаптированная для работы в условиях низкой освещённости, — и ещё более передовые камеры у iPhone 12 Pro Max.</p>
              </Carousel.Caption>
            </Carousel.Item>


            <Carousel.Item className="carousel-item" style={{ height: '600px' }}>
              <Image
                fluid
                className="d-block"
                style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                src="https://mobile-review.com/articles/2020/image/iphone-12-presentation/scr-off/4.jpg"
                alt="5 slide"
              />
              <Carousel.Caption>
                <h3>Аксессуары MagSafe</h3>
                <p>Новые чехлы и зарядные устройства, разработанные специально для iPhone 12 и iPhone 12 Pro. Встроенные магниты надёжно удерживают аксессуары на месте и повышают скорость беспроводной зарядки.</p>
              </Carousel.Caption>
            </Carousel.Item>
          </Carousel>
        </Container>
      </Container>
    );
  }
}