package leetCode._3100

object Solution_3079 {
  def sumOfEncryptedInt(nums: Array[Int]): Int = nums
    .map(n => (n.toString.toList.max, n.toString.length))
    .map(n => Array.fill(n._2)(n._1).mkString.toInt)
    .sum
}
