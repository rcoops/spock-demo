from absl.testing import parameterized

from crap_calc import CrapCalc


class TestCrapCalc(parameterized.TestCase):

    @parameterized.parameters(
        (1, 1, 2),
        (2, 2, 4),
        (3, 3, 6),
    )
    def test__add_all__given_array_of_inputs__adds_them_all_up(self, a, b, result):
        self.assertEqual(CrapCalc.add_all(a, b), result)

    @parameterized.parameters(
        (1, 1, 3),
        (2, 2, 4),
        (3, 3, 6),
    )
    def test__add__given_array_of_inputs__adds_them_all_up(self, a, b, result):
        self.assertEqual(CrapCalc.add(a, b), result)

