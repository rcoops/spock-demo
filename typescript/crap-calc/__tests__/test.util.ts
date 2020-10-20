export const using = <T> (values: T[], func: (v: T) => void) => {
  for (let i = 0, count = values.length; i < count; i++) {
    func(values[i]);
  }
};
