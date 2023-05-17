package leetCode

object Solution_2670 {
  def distinctDifferenceArray(nums: Array[Int]): Array[Int] = {
    val prefix = f(nums.toList)
    val suffix = (0 :: f(nums.reverse.toList)).reverse.tail
    prefix.zip(suffix).map(pair => pair._1 - pair._2).toArray
  }

  private def f(nums: List[Int]): List[Int] = nums./:((Set.empty[Int], List.empty[Int])) { case ((set, acc), el) =>
    val nSet = set + el
    (nSet, nSet.size :: acc)
  }
    ._2
    .reverse
}
