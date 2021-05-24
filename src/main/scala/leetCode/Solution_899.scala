package leetCode

object Solution_899 {
  def f(S: String, len: Int): String =
    (0 until len).map(i => S.slice(i, i + len)).min

  def orderlyQueue(S: String, K: Int): String = {
    if (K == 1) return f(S + S, S.length)
    S.sorted
  }
}
