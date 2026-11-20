package leetCode._4100

object Solution_4049 {
  def countSpecialIntegers(nums: Array[Int]): Int = nums
    .zipWithIndex
    .groupBy(_._1)
    .values
    .count { p =>
      val indices = p.map(_._2).sorted
      indices.length >= 3 && indices.sliding(2).map(x => x(1) - x(0)).toSet.size == 1
    }
}
