package leetCode._700

object Solution_679 {
  def judgePoint24(nums: Array[Int]): Boolean = {
    def f(nums: List[Float]): Boolean = nums match {
      case a :: Nil => (a - 24.0).abs < 0.001
      case a :: b :: xs => List(a + b, a - b, a * b, a / b)
        .map(_ :: xs)
        .flatMap(_.permutations)
        .exists(f)
      case Nil => false
    }

    nums.map(_.toFloat).toList.permutations.exists(f)
  }
}
