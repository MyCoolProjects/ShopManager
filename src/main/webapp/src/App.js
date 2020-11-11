import React from 'react';
// import logo from './logo.svg';
import './App.css';
import Header from './Header/Header.js';
import Footer from './Footer/Footer.js';
import Home from './Home/Home.js';
import ProductsList from './Catalog/ProductsList.js';
import ProductFetch from './Product/ProductFetch.js';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (
    <BrowserRouter>
      <Header></Header>
      {/* пропуск места из-за фиксированного header */}<div style={{ height: '104px' }}></div>
      <Switch>
        <Route path="/catalog" component={ProductsList} />
        <Route path="/product/:id" component={ProductFetch} />
        <Route path="/" component={Home} />
      </Switch>
      <Footer></Footer>
      {/* exact нужен для того, чтобы загружалась при пасе в один корень P.S. Загружает при npm start*/}
    </BrowserRouter>
  );
}

export default App;
