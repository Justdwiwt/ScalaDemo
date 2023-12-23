package leetCode

object Solution_2960 {
  def countTestedDevices(batteryPercentages: Array[Int]): Int = {
    var res = 0
    batteryPercentages.foreach(b => if (b - res > 0) res += 1)
    res
  }
}
