import React from 'react';
// import logo from './logo.svg';
import './App.css';
import Header from './Header/Header';
import Footer from './Footer/Footer';
import Home from './Home/Home';
import ProductsList from './Catalog/ProductsList';
import ProductFetch from './Product/ProductFetch';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductPanel from './ProductPanel/ProductPanel';

function App() {
  return (
    <BrowserRouter>
      <Header></Header>
      {/* пропуск места из-за фиксированного header */}
      <div style={{ height: '104px' }}></div>
      <Switch>
        <Route path="/catalog" component={ProductsList} />
        <Route path="/product/:id" component={ProductFetch} />
        <Route path="/product-panel" component={ProductPanel} />
        <Route path="/" component={Home} />
      </Switch>
      <Footer></Footer>
      {/* exact нужен для того, чтобы загружалась при пасе в один корень P.S. Загружает при npm start*/}
    </BrowserRouter>
  );
}

export default App;
