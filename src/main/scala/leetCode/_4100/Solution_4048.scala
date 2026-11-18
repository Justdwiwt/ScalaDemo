package leetCode._4100

object Solution_4048 {
  def countSpecialIntegers(nums: Array[Int]): Int = nums
    .zipWithIndex
    .groupBy(_._1)
    .values
    .count(v => v.length == 3 && v(1)._2 - v(0)._2 == v(2)._2 - v(1)._2)
}
