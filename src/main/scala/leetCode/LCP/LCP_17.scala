package leetCode.LCP

object LCP_17 {
  def calculate(s: String): Int = {
    val (a, b) = s./:((1, 0)) { case ((x, y), s) =>
      if (s == 'A') (2 * x + y, y) else (x, 2 * y + x)
    }
    a + b
  }
}
