package leetCode._700

object Solution_665 {
  def checkPossibility(nums: Array[Int]): Boolean =
    f(nums.min, nums.min, nums.toList)

  @scala.annotation.tailrec
  def f(pre: Int, cur: Int, nums: List[Int]): Boolean = nums match {
    case Nil => true
    case xs :: ys =>
      if (cur > xs)
        if (pre > xs) g(cur +: ys)
        else g(pre +: nums)
      else f(cur, xs, ys)
  }

  def g(nums: List[Int]): Boolean =
    nums.zip(nums.drop(1)).map(t => t._1 - t._2).forall(_ <= 0)
}
