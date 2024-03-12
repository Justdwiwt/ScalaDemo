package leetCode._2300

object Solution_2289 {
  def totalSteps(nums: Array[Int]): Int = {
    val M = Int.MaxValue / 2

    @scala.annotation.tailrec
    def f(nums: List[Int], stack: List[(Int, Int)], res: Int): Int = nums match {
      case Nil => res
      case x :: xs =>
        val (l, r) = stack.span(_._1 <= x)
        val step = if (l == Nil) 1 else l.map(_._2).max + 1
        f(xs, (x, step) :: r, res.max(if (step >= M) 0 else step))

    }

    f(nums.drop(1).toList, List((nums.head, M)), 0)
  }
}
