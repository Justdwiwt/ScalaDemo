package leetCode._2600

object Solution_2517 {
  def maximumTastiness(price: Array[Int], k: Int): Int = {
    val list = price.sorted.toList

    def f(n: Int): Boolean = {
      @scala.annotation.tailrec
      def g(ls: List[Int], curr: Int): Boolean = {
        if (curr == 0) true
        else ls match {
          case Nil => false
          case x :: _ => g(ls.dropWhile(_ - x < n), curr - 1)
        }
      }

      g(list, k)
    }

    @scala.annotation.tailrec
    def solve(l: Int, h: Int): Int = {
      if (l == h) l
      else {
        val m = (l + h + 1) / 2
        if (f(m)) solve(m, h)
        else solve(l, m - 1)
      }
    }

    solve(0, 1000000005)
  }
}
