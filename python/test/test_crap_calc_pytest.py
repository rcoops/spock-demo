from pytest import mark

from crap_calc import CrapCalc

parametrize = mark.parametrize


params = [
    (1, 1, 3),
    (2, 2, 4),
    (3, 3, 6),
]


@parametrize("a,b,expected", params)
def test__add_all__given_array_of_inputs__adds_them_all_up(a, b, expected):
    assert CrapCalc.add_all(a, b) == expected


@parametrize("a,b,expected", params)
def test__add__given_array_of_inputs__adds_them_all_up(a, b, expected):
    assert CrapCalc.add(a, b) == expected

