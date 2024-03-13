package leetCode._3000

object Solution_2960 {
  def countTestedDevices(batteryPercentages: Array[Int]): Int =
    batteryPercentages.foldLeft(0)((tested, battery) => if (battery - tested > 0) tested + 1 else tested)
}
