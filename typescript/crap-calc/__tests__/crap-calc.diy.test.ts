import CrapCalc from '../src/crap-calc';
import { using } from './test.util';

describe('CrapCalc', () => {
  const calc = new CrapCalc();

  using([
    [1, 1, 3],
    [2, 2, 4],
    [3, 3, 6],
  ], ([one, two, expectedResult]: [number, number, number]) => {
    it(`addAll(${one}, ${two}) = ${expectedResult}`, () => {
      expect(calc.addAll(one, two)).toBe(expectedResult);
    });
  });

});
