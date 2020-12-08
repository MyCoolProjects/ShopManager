import React, { Component } from 'react';
import { Container, Carousel, Image } from 'react-bootstrap';
import './Home.css';
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      newsposts: []
    };
  }

  componentDidMount() {
    fetch('/api/newsposts')
      .then(res => {
        if (!res.ok) throw new Error('Not 2xx response');
        return res;
      })
      .then(res => res.json())
      .then((result) => {
        if (!result) throw new Error('Empty response');
        this.setState({
          isLoaded: true,
          newsposts: result.news_posts
        });
      })
      .catch((error) => {
        this.setState({
          isLoaded: true,
          error
        });
      });
  }

  render() {
    return (
      <Container fluid style={{ fontSize: 20 }} key={this.props.id} expand="md">
        <Container>
          <Carousel variant="secondary">

            {this.state.newsposts.map((post) =>
              <Carousel.Item key={post.id} className="carousel-item" style={{ height: '600px' }}>
                {(post.image &&
                  <Image
                    fluid
                    className="d-block"
                    style={{ position: 'center', objectFit: 'cover', height: '100%' }}
                    src={`/images/${post.image.id}`}
                  />) ||
                  <div style={{ background: 'black', width: '100%', height: '100%' }} />}
                <Carousel.Caption>
                  <h3>{post.title}</h3>
                  <p>{post.description}</p>
                </Carousel.Caption>
              </Carousel.Item>
            )}

          </Carousel>
        </Container>
      </Container>
    );
  }
}