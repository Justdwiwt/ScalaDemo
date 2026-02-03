package leetCode._3800

object Solution_3800 {
  def minimumCost(s: String, t: String, flipCost: Int, swapCost: Int, crossCost: Int): Long = {
    val (a0, b0) = s.zip(t).foldLeft((0L, 0L)) {
      case ((a, b), ('0', '1')) => (a + 1, b)
      case ((a, b), ('1', '0')) => (a, b + 1)
      case (acc, _) => acc
    }

    val (a, b) = if (a0 <= b0) (a0, b0) else (b0, a0)

    val res1 = (a + b) * flipCost
    val res2 = a * swapCost + (b - a) * flipCost

    val avg = (a + b) / 2
    val rem = (a + b) % 2
    val res3 = (avg - a) * crossCost + avg * swapCost + rem * flipCost

    math.min(res1, math.min(res2, res3))
  }
}
