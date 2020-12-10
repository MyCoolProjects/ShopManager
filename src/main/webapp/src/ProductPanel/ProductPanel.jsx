import React, { Fragment, useRef, useState } from 'react';
import {
  Button,
  Card,
  CardDeck,
  Container,
  Form,
  InputGroup,
} from 'react-bootstrap';
import { v4 as uuidv4 } from 'uuid';
import CopyToClipboard from './CopyToClipboard';

const ProductPanel = () => {
  const HOST_URL = process.env.REACT_APP_HOST_URL || '';

  const [images, setImages] = useState([]);
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const [description, setDescription] = useState('');
  // const [specs] = useState([]);
  const [status, setStatus] = useState('');
  const productIdRef = useRef();

  const handleFileChange = (event) => {
    event.preventDefault();
    const reader = new FileReader();

    console.log(event.target.files);
    if (event.target.files.item(0))
      reader.readAsDataURL(event.target.files.item(0));
    reader.onload = () => {
      let data = {};

      if (typeof reader.result === 'string') data = reader.result;
      else data = Buffer.from(reader.result).toString();

      if (data) setImages([...images, { id: uuidv4(), data }]);
    };
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setStatus('');

    const newProduct = {
      name,
      price: price.replaceAll(',', '.'),
      description,
      // eslint-disable-next-line camelcase
      category: {
        id: 1,
      },
      specifications: null,
    };

    try {
      console.log(newProduct);
      const res = await fetch(`${HOST_URL}api/products`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newProduct),
      });
      if (!res.ok) res.json().then((data) => console.log(data.message));
      const data = await res.json();

      console.log(data.id);
      productIdRef.current = data.id;
      console.log(productIdRef.current);
      setStatus('success');
    } catch (error) {
      console.log(error);
      setStatus('error');
      return;
    }
    for (const image of images) {
      try {
        const newImage = {
          payload: image.data,
          // eslint-disable-next-line camelcase
          product_id: productIdRef.current,
        };
        console.log(newImage);
        const res = fetch(`${HOST_URL}images`, {
          // const res = fetch('https://echo-api.3scale.net/', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(newImage),
        });
        // eslint-disable-next-line no-await-in-loop
        if (!res.ok) console.log(await res.json);
        console.log(res);
      } catch (error) {
        console.log(error);
      }
    }
  };

  const handlePriceChange = (event) => {
    try {
      if (!event.target.validity.valid) throw new Error('Price is NaN');
      setPrice(event.target.value);
      setStatus('');
    } catch (error) {
      event.preventDefault();
    }
  };

  const addCategory = () => {
    fetch('/api/categories', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: 'Test Category',
      }),
    });
  };

  return (
    <div>
      <Container className="border">
        <Form className="p-3">
          <Button className="mb-3" onClick={addCategory}>
            Добавить категорию
          </Button>
          <Form.Group>
            <Form.Label>Наименование</Form.Label>
            <Form.Control
              onChange={(event) => {
                setName(event.target.value);
                setStatus('');
              }}
              value={name}
              type="text"
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Цена</Form.Label>
            <Form.Control
              pattern="\d+,?\d?\d?"
              onInput={handlePriceChange}
              value={price}
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Описание</Form.Label>
            <Form.Control
              onChange={(event) => {
                setDescription(event.target.value);
                setStatus('');
              }}
              value={description}
              as="textarea"
            />
          </Form.Group>
          <Form.Group>
            <InputGroup>
              <Form.File
                onChange={handleFileChange}
                accept=".jpg, .jpeg, .png"
              />
            </InputGroup>
          </Form.Group>
          <InputGroup>
            <InputGroup.Prepend>
              <Button onClick={handleSubmit} variant="secondary" type="submit">
                Submit
              </Button>
            </InputGroup.Prepend>
            <InputGroup.Append className="flex-grow-1 flex-shrink-1">
              {status === '' && (
                <InputGroup.Text className="p-3 w-100">
                  No request
                </InputGroup.Text>
              )}
              {status === 'success' && (
                <InputGroup.Text className="bg-success text-white p-3 ">
                  Success, id: {productIdRef.current}
                </InputGroup.Text>
              )}
              {status === 'error' && (
                <InputGroup.Text className="bg-danger text-white p-3">
                  Error
                </InputGroup.Text>
              )}
            </InputGroup.Append>
          </InputGroup>
        </Form>
        <Container className="d-flex" style={{ flexWrap: 'wrap' }}>
          <CardDeck>
            {images.map((image) => (
              <Fragment key={image.id}>
                <Card
                  style={{ maxWidth: '20em', minWidth: '20em', height: '30%' }}
                >
                  <Card.Img
                    style={{
                      overflow: 'hidden',
                      objectFit: 'cover',
                      flex: '1 1 auto',
                    }}
                    src={image.data}
                  />
                  <Card.Footer>
                    <CopyToClipboard image={image.data} />
                  </Card.Footer>
                </Card>
              </Fragment>
            ))}
          </CardDeck>
        </Container>
      </Container>
    </div>
  );
};

ProductPanel.propTypes = {};

export default ProductPanel;
