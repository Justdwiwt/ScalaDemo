package leetCode

object Solution_1614 {
  def maxDepth(s: String): Int = s.filter("()".contains(_)).map(c => if (c == '(') 1 else -1).scan(0)(_ + _).max
}
