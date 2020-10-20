export default class {
  add(one: number, two: number): number {
    return one + two;
  }
  addAll(...numbers: number[]): number {
    return numbers.reduce((agg, cur) => this.add(agg, cur), 0);
  }
}
