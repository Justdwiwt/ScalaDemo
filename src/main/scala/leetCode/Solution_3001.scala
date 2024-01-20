package leetCode

object Solution_3001 {
  def minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int = {
    if (a == e && (c != e || c == e && (d - b) * (d - f) > 0) || b == f && (d != f || d == f && (c - a) * (c - e) > 0))
      return 1
    if (c - d == e - f && (a - b != e - f || a - b == e - f && (a - c) * (a - e) > 0) || c + d == e + f && (a + b != e + f || a + b == e + f && (a - c) * (a - e) > 0))
      return 1
    2
  }
}
