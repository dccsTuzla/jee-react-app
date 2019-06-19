/*
 *  Copyright (c) 2019 DCCS GmbH. All rights reserved.
 *  Implemented 2019 by DCCS GmbH.
 */

var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var CleanWebpackPlugin = require('clean-webpack-plugin');
var path = require('path');
var tslintConfig = require('./tslint.json');

var outputFolder = path.resolve(__dirname, 'dist');

module.exports = {
  entry: {
    app: "./app/index.tsx"
  },
  output: {
    path: outputFolder,
    filename: '[name].bundle.js',
    chunkFilename: '[name].bundle.js'
  },

  optimization: {
    splitChunks: {
      cacheGroups: {
        moment: {
          test: /[\\/]node_modules[\\/](moment)[\\/]/,
          name: 'moment',
          chunks: 'all'
        },
        vendor: {
          test: /[\\/]node_modules[\\/](react|react-dom)[\\/]/,
          name: 'vendor',
          chunks: 'all'
        }
      }
    }
  },

  resolve: {
    // Add '.ts' and '.tsx' as resolvable extensions.
    extensions: ['.js', '.jsx', '.json', '.ts', '.tsx']
  },

  module: {
    rules: [
      // All files with a '.ts' or '.tsx' extension will be handled by 'awesome-typescript-loader'.
      {test: /\.(ts|tsx)$/, loader: "awesome-typescript-loader"},
      // Scss typescript loader.
      {
        test: /\.scss$/,
        include: [
          path.resolve(__dirname, "app/themes")
        ],
        use: [
          {loader: "style-loader"},
          {
            loader: "typings-for-css-modules-loader",
            options: {
              namedExport: true,
              camelCase: true,
              modules: true
            }
          },
          {loader: "sass-loader"}
        ]
      },
      // Load svgs.
      {
        test: /\.(svg)$/,
        use: [{loader: 'raw-loader'}]
      },
      // All output '.js' files will have any sourcemaps re-processed by 'source-map-loader'.
      {enforce: "pre", test: /\.js$/, loader: "source-map-loader"},
      // Run tslint check.
      {
        enforce: 'pre',
        test: /\.tsx$/,
        use: [{loader: 'tslint-loader', options: tslintConfig}]
      }
    ]
  },
  plugins: [
    new CleanWebpackPlugin([outputFolder], {allowExternal: true}),
    new webpack.WatchIgnorePlugin([/\.scss.d.ts$/]),
    new HtmlWebpackPlugin({
                            template: 'index.html'
                          }),
    new CopyWebpackPlugin([{from: '../static/*.*', to: './', flatten: true}], {})
  ]
};
