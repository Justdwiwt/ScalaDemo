package leetCode.crackingCodeInterview

object Code_08_01 {
  def waysToStep(n: Int): Int = n match {
    case n if n < 3 => n
    case 3 => 4
    case n =>
      (4 to n).foldLeft((1, 2, 4)) { case ((a, b, c), _) =>
        (b, c, ((a + b) % 1000000007 + c) % 1000000007)
      }._3
  }
}
