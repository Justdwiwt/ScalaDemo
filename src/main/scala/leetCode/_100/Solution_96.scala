package leetCode._100

object Solution_96 {
  def numTrees(n: Int): Int = f(n, List(1))

  @scala.annotation.tailrec
  def f(n: Int, nums: List[Int]): Int =
    if (n == 0) nums.last
    else f(n - 1, nums :+ nums.zipWithIndex./:(0)((acc, pair) => acc + pair._1 * nums(nums.length - 1 - pair._2)))
}
