from functools import reduce


class CrapCalc:

    @staticmethod
    def add(one, two):
        return one + two

    @staticmethod
    def add_all(*numbers):
        return reduce(CrapCalc.add, numbers)

