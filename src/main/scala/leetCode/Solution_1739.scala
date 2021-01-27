package leetCode

object Solution_1739 {
  def minimumBoxes(n: Int): Int = {
    var total = 0
    var floor = 0
    var t = 0
    while (total + floor < n) {
      t += 1
      floor += t
      total += floor
    }
    var buffD = 0
    while (total < n) {
      buffD += 1
      total += buffD
    }
    floor + buffD
  }
}
