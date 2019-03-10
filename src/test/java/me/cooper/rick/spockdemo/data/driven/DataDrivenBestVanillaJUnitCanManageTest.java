package me.cooper.rick.spockdemo.data.driven;

import static org.assertj.core.api.Assertions.assertThat;

import static me.cooper.rick.spockdemo.Fixtures.calc;

import org.junit.Test;

public class DataDrivenBestVanillaJUnitCanManageTest {

  @Test
  public void add_givenOneAndOne_returnsTwo() {
    add_givenXAndY_returnsZ(1, 1, 2);
  }

  @Test
  public void add_givenTwoAndTwo_returnsFour() {
    add_givenXAndY_returnsZ(2, 2, 4);
  }

  @Test
  public void add_givenThreeAndThree_returnsSix() {
    add_givenXAndY_returnsZ(3, 3, 6);
  }

  private void add_givenXAndY_returnsZ(final int x, final int y, final int z) {
    assertThat(calc.add(x,y)).isEqualTo(z);
  }
}
