/*
 *  Copyright (c) 2022 DCCS GmbH. All rights reserved.
 *  Implemented 2022 by DCCS GmbH.
 */

import * as React from 'react';
import * as ReactDOM from 'react-dom';
import { App } from './views/app/App';
import './themes/basic.scss';

/**
 * Attaches the application in the dom.
 */
ReactDOM.render(<App />, document.getElementById('root'));
