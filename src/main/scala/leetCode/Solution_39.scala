package leetCode

object Solution_39 {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    def f(nums: List[Int], left: Int, acc: List[Int]): List[List[Int]] =
      if (left < 0) Nil
      else if (left == 0) List(acc)
      else nums match {
        case Nil => Nil
        case x :: xs => f(x :: xs, left - x, x :: acc) ::: f(xs, left, acc)
      }

    f(candidates.toList, target, Nil)
  }
}
