import CrapCalc from '../src/crap-calc';

describe('CrapCalc', () => {
  const calc = new CrapCalc();

  describe.each`
  one   | two   | expectedResult
  ${1}  | ${1}  | ${3}
  ${2}  | ${2}  | ${4}
  ${3}  | ${3}  | ${6}
  `('addAll($one, $two)', ({ one, two, expectedResult}) => {
    it(`= ${expectedResult}`, () => {
      expect(calc.addAll(one, two)).toBe(expectedResult);
    });
  });

  describe.each([
    [1, 1, 3],
    [2, 2, 4],
    [3, 3, 6],
  ])('addAll(%d, %d)', (one, two, expectedResult) => {
    it(`= ${expectedResult}`, () => {
      expect(calc.addAll(one, two)).toBe(expectedResult);
    });
  });

  it.each`
  one   | two   | expectedResult
  ${1}  | ${1}  | ${3}
  ${2}  | ${2}  | ${4}
  ${3}  | ${3}  | ${6}
  `('add($one, $two) = $expectedResult', ({ one, two, expectedResult}) => {
    expect(calc.add(one, two)).toBe(expectedResult);
  });
});
