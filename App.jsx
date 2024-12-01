
import React from 'react';


import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import BookComponent from './component/BookComponent';
import FooterComponent from './component/FooterComponent';
import HeaderComponent from './component/HeaderComponent';
import ListBookComponent from './component/ListBookComponent';

function App() {
  

  return (
    <div>
      <BrowserRouter>
      <HeaderComponent/>
      <Routes>
<Route path='/' element={<ListBookComponent/>}></Route>
<Route path='/books' element={<ListBookComponent/>}></Route>
<Route path='/addbook' element={<BookComponent/>}></Route>
<Route path='/updatebook/:id' element={<BookComponent/>}></Route>
<Route path='/getbook/:id' element={<BookComponent/>}></Route>



      </Routes>
  
  <FooterComponent/>
  </BrowserRouter>  
    </div>
  );
}

export default App
