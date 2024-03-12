package leetCode._2600

object Solution_2562 {
  def findTheArrayConcVal(nums: Array[Int]): Long = (nums.take(nums.length / 2) :+ 0)
    .map(_.toString)
    .zip(nums.drop(nums.length / 2).map(_.toString).reverse)
    .map(n => (n._1 + n._2).toLong)
    .sum
}
