package leetCode._3900

object Solution_3868 {
  def minCost(nums1: Array[Int], nums2: Array[Int]): Int = {
    val diff = (nums1.map(_ -> 1) ++ nums2.map(_ -> -1))
      .groupBy(_._1)
      .mapValues(_.map(_._2).sum)

    diff.values.foldLeft(Option(0)) {
      case (None, _) => None
      case (Some(_), d) if d % 2 != 0 => None
      case (Some(s), d) if d > 0 => Some(s + d)
      case (Some(s), _) => Some(s)
    }.map(_ / 2).getOrElse(-1)
  }
}
