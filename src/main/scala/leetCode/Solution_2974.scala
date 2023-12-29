package leetCode

object Solution_2974 {
  def numberGame(nums: Array[Int]): Array[Int] = nums
    .sorted
    .grouped(2)
    .flatMap(a => Seq(a(1), a.head))
    .toArray
}
