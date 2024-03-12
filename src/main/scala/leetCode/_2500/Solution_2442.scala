package leetCode._2500

object Solution_2442 {
  def reverse(i: Int): Int = i.toString.reverse.toInt

  def countDistinctIntegers(nums: Array[Int]): Int =
    (nums ++ nums.map(reverse)).distinct.length
}
