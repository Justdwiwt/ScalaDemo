package leetCode

object Solution_2592 {
  def maximizeGreatness(nums: Array[Int]): Int = {
    val sorted = nums.sorted.toList
    f(sorted, sorted, 0)
  }

  @scala.annotation.tailrec
  private def f(nums: List[Int], perm: List[Int], acc: Int): Int = (nums, perm) match {
    case (_, Nil) => acc
    case (n :: nTail, p :: pTail) =>
      if (p > n) f(nTail, pTail, acc + 1)
      else f(nums, pTail, acc)
    case _ => ???
  }
}
