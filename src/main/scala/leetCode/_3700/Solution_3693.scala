package leetCode._3700

object Solution_3693 {
  def climbStairs(n: Int, costs: Array[Int]): Int = costs.foldLeft((0, 0, 0)) {
    case ((f0, f1, f2), c) =>
      val nf2 = (f2 + 1).min((f0 + 9).min(f1 + 4)) + c
      (f1, f2, nf2)
  }._3
}
