import React, { Component } from "react";
import { Container, Button, Spinner } from 'react-bootstrap';

import Product from './Product.js'


class ProductFetch extends Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            currProduct: null
        };
    }
    componentDidMount() {
        const id = this.props.match.params.id;
        fetch(`/api/product/${id}`)
            .then((res) => {
                if (!res.ok) throw new Error("Not 2xx response");
                return res;
            })
            .then(res => res.json())
            .then((result) => {
                if (!result) throw new Error("Empty response");
                this.setState({
                    isLoaded: true,
                    currProduct: result
                });
            })
            .catch(err => {
                console.log(err)
                // fetch("/Main.json")
                //     .then(res => res.json())
                //     .then((result) => {
                //         const currProduct = result.products.find((p) => p.id == id);
                //         this.setState({
                //             isLoaded: true,
                //             currProduct
                //         });
                //     },
                //         (error) => {
                //             this.setState({
                //                 isLoaded: true,
                //                 error
                //             })
                //         }
                //     )
            });
    };

    render() {
        const { error, isLoaded, currProduct } = this.state;
        if (error) {
            return (
                <div>Error {error.message}</div>
            )
        }
        else if (!isLoaded) {
            return (
                <Container fluid className="pt-5 mt-5" style={{ textAlign: "center", verticalAlign: "middle", height: "757px", fontSize: 40 }}>
                    <Button variant="dark" disabled>
                        <Spinner
                            as="span"
                            animation="border"
                            size="md"
                            role="status"
                            aria-hidden="true"
                        />
                        {" "} Loading...
                    </Button>
                </Container>
            )
        }
        else {
            return (
                <Product currProduct={currProduct} />
            )
        }
    }
}

export default ProductFetch;