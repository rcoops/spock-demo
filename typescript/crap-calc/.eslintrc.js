module.exports = {
  extends: [
    'airbnb-typescript/base',
  ],
  parserOptions: {
    project: [
      './tsconfig.json',
      './__tests__/tsconfig.json',
    ],
  },
  ignorePatterns: [
    'deployment'
  ],
};
