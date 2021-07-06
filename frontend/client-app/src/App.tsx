import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import 'semantic-ui-css/semantic.min.css';
import { Header, List, ListListProps } from 'semantic-ui-react';

function App() {
  const [auction, setAuction] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/product/Legacy/Model/auction').then(response => {
      console.log(response);
      setAuction(response.data); 
    })
  }, [])

  return (
    <div>
      <Header as='h2' icon='users' content='BakuganApp' />
      {{auction}}
    </div>
  );
}

export default App;
