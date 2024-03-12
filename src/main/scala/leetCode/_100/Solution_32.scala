package leetCode._100

object Solution_32 {
  def longestValidParentheses(s: String): Int = {
    @scala.annotation.tailrec
    def f(stack: List[Int], n: Int, lenLast: Int, lenMax: Int): Int =
      if (n >= s.length) lenMax
      else {
        val sn = s(n)
        val (st, last, len) = sn match {
          case '(' => ((n - lenLast) :: stack, 0, lenMax)
          case ')' if stack == Nil => (Nil, 0, lenMax)
          case ')' =>
            val t = n + 1 - stack.head
            (stack.tail, t, lenMax.max(t))
        }
        f(st, n + 1, last, len)
      }

    f(Nil, 0, 0, 0)
  }
}
