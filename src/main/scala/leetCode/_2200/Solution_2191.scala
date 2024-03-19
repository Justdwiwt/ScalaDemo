package leetCode._2200

object Solution_2191 {
  def sortJumbled(mapping: Array[Int], nums: Array[Int]): Array[Int] = nums
    .sorted(Ordering.by[Int, Int](_
      .toString
      .toCharArray
      .map(_ - 48)
      .map(mapping(_).toString)
      .mkString
      .toInt
    ))
}
