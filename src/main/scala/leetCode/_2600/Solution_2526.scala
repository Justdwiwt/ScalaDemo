package leetCode._2600

object Solution_2526 {
  class DataStream(_value: Int, _k: Int) {
    var count = 0

    def consec(num: Int): Boolean =
      if (num != _value) {
        count = 0
        false
      } else {
        count += 1
        count >= _k
      }
  }
}
