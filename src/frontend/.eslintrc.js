/*
 *  Copyright (c) 2022 DCCS GmbH. All rights reserved.
 *  Implemented 2022 by DCCS GmbH.
 */

module.exports =  {
    parser:  '@typescript-eslint/parser',  // Specifies the ESLint parser
    extends:  [
        'plugin:react/recommended',  // Uses the recommended rules from @eslint-plugin-react
        'plugin:@typescript-eslint/recommended',  // Uses the recommended rules from @typescript-eslint/eslint-plugin
        'prettier',  // Uses eslint-config-prettier to disable ESLint rules from @typescript-eslint/eslint-plugin that would conflict with prettier
    ],
    parserOptions:  {
        ecmaVersion:  2018,  // Allows for the parsing of modern ECMAScript features
        sourceType:  'module',  // Allows for the use of imports
        ecmaFeatures:  {
            jsx:  true,  // Allows for the parsing of JSX
        },
    },
    ignorePatterns: ["app-rest.ts"],
    rules:  {
        "no-unused-vars": 'off',
        "@typescript-eslint/no-unused-vars": 'off',
        "@typescript-eslint/explicit-module-boundary-types": 'off',
        "@typescript-eslint/no-non-null-assertion": 'error',
        "@typescript-eslint/no-explicit-any": 'off',
        "@typescript-eslint/no-empty-function": 'off',
        "@typescript-eslint/ban-types": 'off',
        "react/display-name": 'off',
        "react/prop-types": 'off',
        "react/jsx-key": 'off'
    },
    settings:  {
        react:  {
            version:  'detect',  // Tells eslint-plugin-react to automatically detect the version of React to use
        },
    },
};
