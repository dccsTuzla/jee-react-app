/*
 *  Copyright (c) 2019 DCCS GmbH. All rights reserved.
 *  Implemented 2019 by DCCS GmbH.
 */

var merge = require('webpack-merge');
var HtmlWebpackExternalsPlugin = require('html-webpack-externals-plugin');
var baseWebpackConfig = require('./webpack.config.js');


// Load Development configuration.
module.exports = merge(baseWebpackConfig, {
  devtool: "source-map",
  devServer: {
    port: '9000',
    proxy: {
      '/rest': {
        target: 'http://localhost:8080',
        secure: false
      }
    },
    inline: false
  },
  plugins: [
    new HtmlWebpackExternalsPlugin({
                                     externals: [
                                       {
                                         module: 'react',
                                         entry: '../../node_modules/react/umd/react.development.js'
                                       }, {
                                         module: 'react-dom',
                                         entry: '../../node_modules/react-dom/umd/react-dom.development.js'
                                       }
                                     ]
                                   })
  ],
  externals: {
    "react": "React",
    "react-dom": "ReactDOM"
  }
});
