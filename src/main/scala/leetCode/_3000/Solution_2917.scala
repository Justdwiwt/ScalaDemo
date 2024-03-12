package leetCode._3000

object Solution_2917 {
  def findKOr(nums: Array[Int], k: Int): Int = nums
    .flatMap(_.toBinaryString.reverse.zipWithIndex)
    .filter(_._1 == '1')
    .groupBy(_._2)
    .mapValues(_.length)
    .filter(_._2 >= k)
    .map(n => math.pow(2, n._1))
    .sum
    .toInt
}
