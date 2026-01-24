package leetCode._3800

object Solution_3769 {
  def sortByReflection(nums: Array[Int]): Array[Int] = nums
    .map(n => (Integer.parseInt(n.toBinaryString.reverse, 2), n))
    .sortBy(n => (n._1, n._2))
    .map(_._2)
}
