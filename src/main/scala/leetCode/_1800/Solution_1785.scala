package leetCode._1800

object Solution_1785 {
  def minElements(nums: Array[Int], limit: Int, goal: Int): Int =
    (((goal - nums.foldLeft(0L)(_ + _)).abs + limit - 1) / limit).toInt
}
