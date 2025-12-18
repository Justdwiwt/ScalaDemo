package leetCode._3700

object Solution_3638 {
  def maxBalancedShipments(weight: Array[Int]): Int = weight
    .zipWithIndex
    .foldLeft((0, 0, 0)) {
      case ((count, max, j), (v, i)) =>
        if (v < max && i > j) (count + 1, 0, i + 1)
        else (count, max.max(v), j)
    }._1
}
