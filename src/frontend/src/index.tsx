/*
 *  Copyright (c) 2022 DCCS GmbH. All rights reserved.
 *  Implemented 2022 by DCCS GmbH.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import { App } from './views/app/App';
import './themes/basic.module.scss';

/**
 * Attaches the application in the dom.
 */
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
