package leetCode

object Solution_1710 {
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int =
    boxTypes.sortWith(_ (1) > _ (1))./:((0, 0))((acc, arr) => {
      if (acc._1 < truckSize) {
        val cnt = if ((truckSize - acc._1) >= arr.head) arr.head else truckSize - acc._1
        (acc._1 + cnt, acc._2 + cnt * arr(1))
      } else acc
    })._2
}
