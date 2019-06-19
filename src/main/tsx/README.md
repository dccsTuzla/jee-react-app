# Example ReactJS application

### Requirements

- NodeJS 10 https://nodejs.org/en/

Other versions have not been tested, but may work.

### Technologies

Application is using the following technologies

- ReactJS https://reactjs.org/
- TypeScript https://www.typescriptlang.org/
- CSS modules https://github.com/css-modules/css-modules
- SASS https://sass-lang.com/
- Webpack https://webpack.js.org/

### Quick start

To build and start the application, run the following commands from the directory that has
the `package.json` file

```
npm install
npm run generate-sass-typings
npm run dev
```

This will build the application and start the Webpack dev server that will serve the
application on http://localhost:9000. Any changes to the files will get picked up immediately
as long as the last command is running.

### Additional NPM commands

Besides the two commands mentioned above, several `npm` commands are available to ensure code
quality

- [TSLint](https://palantir.github.io/tslint/) integration with `npm run tslint`
- [Prettier](https://prettier.io/) integration with `npm run prettier && npm run prettiercss`
- [Madge](https://github.com/pahen/madge) integration with `npm run madge`

All three commands are also bundled in a single `npm` command

```
npm run precommit
```

### REST proxy

To simplify development of REST applications, a [proxy](https://webpack.js.org/configuration/dev-server/#devserverproxy) is provided for the REST
application running on port 8080. All calls to http://localhost:9000/rest/* will be
proxied to http://localhost:8080/rest/* to ensure that both REST and client applications
run on the same domain. 

Note that TomEE must be running for this to work. The application will fetch the data
from user's resource defined in REST application at startup and try to display any
users it may find.

### Getting started with React programming using TypeScript

Text format explanation:
- _this is informational text that can be read, but not much emphasis should be put on it_*
- ~~this is part that should not be read~~

We recommend going through suggested tutorials in the specified order.

- JavaScript (https://javascript.info/)
   1. _An Introduction_*
   2. JavaScript Fundamentals
   3. _Code quality_*
   4. Object: the basics
   5. Data types
   6. Advanced working with functions
   7. Object properties configuration
   8. Prototypes, inheritance
   9. Classes
  10. Error handling
  11. Promises, async/await
  12. ~~Generators, advanced iteration~~
  13. ~~Modules~~
  14. Document
  15. Introduction to Events

- TypeScript (https://www.typescriptlang.org/docs/home.html)
   1. Basic Types
   2. Variable Declarations
   3. Interfaces
   4. Classes
   5. Functions
   6. Generics
   7. Enums
   8. _Type Inference_*
   9. _Type Compatibility_*
  10. Advanced Types
  11. _Symbols_*
  12. _Iterators and Generators_*
  13. _Modules_*
  14. ~~Namespaces~~
  15. ~~Namespaces and Modules~~
  16. ~~Module Resolution~~
  17. ~~Declaration Merging~~
  18. JSX
  19. Decorators
  20. Mixins
  21. ~~Triple-Slash Directives~~
  22. ~~Type Checking JavaScript Files~~
 

- ReactJS
  - Part 1 https://reactjs.org/tutorial/tutorial.html
  - Part 2 https://reactjs.org/docs/getting-started.html
    - Main Concepts
       1. Hello world
       2. Introducing JSX
       3. Rendering Elements
       4. Components and Props
       5. State and Lifecycle
       6. Handling Events
       7. Conditional Rendering
       8. Lists and Keys
       9. Forms
      10. Lifting State Up
      11. Composition vs Inheritance
      12. _Thinking In React_*
    - Advanced Guides
       1. Accessibility
       2. Code-Splitting
       3. Context
       4. Error Boundaries
       5. Forwarding Refs
       6. Fragments
       7. Higher-Order Components
       8. ~~Integrating With Other Libraries~~
       9. JSX In Depth
      10. _Optimizing Performance_*
      11. Portals
      12. ~~React Without ES6~~
      13. ~~React Without JSX~~
      14. Reconciliation
      15. Refs and  the DOM
      16. Render Props
      17. ~~Static Type Checking~~
      18. ~~Strict Mode~~
      19. ~~Typechecking with PropTypes~~
      20. Uncontrolled components
      21. ~~Web Components~~
    - API Reference
       1. React
       2. React.Component
       3. ReactDOM
       4. ~~ReactDOMServer~~
       5. DOM Elements
       6. SyntheticEvent
       7. ~~Test Utilities~~
       8. ~~Shallow Renderer~~
       9. ~~Test Renderer~~
      10. ~~JS Environment Requirements~~
      11. _Glossary_*

### Useful resources

- Fetch API https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API
- Axios (using Fetch API is recommended) https://github.com/axios/axios
- React Router https://reacttraining.com/react-router/
- RxJS https://www.learnrxjs.io/
- MomentJS https://momentjs.com/

All of the mentioned packages are included in `package.json` and can be used if necessary.
