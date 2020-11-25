package leetCode

object Solution_1638 {
  def countSubstrings(s: String, t: String): Int = {
    val A = Array.fill(s.length + 1, t.length + 1)(0)
    val B = Array.fill(s.length + 1, t.length + 1)(0)
    (1 until A.length).foreach(i => (1 until A(i).length).foreach(j => if (s(i - 1) == t(j - 1)) A(i)(j) = A(i - 1)(j - 1) + 1))
    s.indices.reverse.foreach(i => t.indices.reverse.foreach(j => if (s(i) == t(j)) B(i)(j) = B(i + 1)(j + 1) + 1))
    var res = 0
    s.indices.foreach(i => t.indices.foreach(j => if (s(i) != t(j)) {
      val left = A(i)(j) + 1
      val right = B(i + 1)(j + 1) + 1
      res += left * right
    }))
    res
  }
}
