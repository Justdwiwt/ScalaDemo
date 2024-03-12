package leetCode._2900

object Solution_2826 {
  def minimumOperations(nums: List[Int]): Int = {
    val (a, b, c) = nums.:\((0, 0, 0)) {
      case (1, (a, b, c)) => (a.min(b + 1).min(c + 1), 1 + b.min(c), c + 1)
      case (2, (a, b, c)) => ((a + 1).min(b).min(c + 1), b.min(c), c + 1)
      case (_, (a, b, c)) => ((a + 1).min(b + 1).min(c), (b + 1).min(c), c)
    }
    a.min(b).min(c)
  }
}
