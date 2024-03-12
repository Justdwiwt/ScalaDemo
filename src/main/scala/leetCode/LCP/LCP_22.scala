package leetCode.LCP

object LCP_22 {
  def paintingPlan(n: Int, k: Int): Int = {
    if (k == n * n) return 1
    var res = 0
    (0 until n).foreach(i => (0 until n).foreach(j => if (i * n + (n - i) * j == k) res += f(i, n) * f(j, n)))
    res
  }

  def f(m: Int, n: Int): Int = g(n) / (g(m) * g(n - m))

  def g(num: Int): Int = if (num <= 1) 1 else num * g(num - 1)
}
