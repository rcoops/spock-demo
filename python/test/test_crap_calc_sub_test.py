import unittest

from crap_calc import CrapCalc


class TestCrapCalc(unittest.TestCase):

    params = [
        (1, 1, 3),
        (2, 2, 4),
        (3, 3, 6),
    ]

    def test__add_all__given_array_of_inputs__adds_them_all_up(self):
        for i, (a, b, result) in enumerate(self.params):
            with self.subTest(f"{a} + {b} = {result}", i=i):
                self.assertEqual(CrapCalc.add_all(a, b), result)

    def test__add_given_inputs__adds_them(self):
        for i, (a, b, result) in enumerate(self.params):
            with self.subTest(f"{a} + {b} = {result}", i=i):
                self.assertEqual(CrapCalc.add(a, b), result)
