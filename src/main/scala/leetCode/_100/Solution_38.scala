package leetCode._100

object Solution_38 {
  def countAndSay(n: Int): String = {
    @scala.annotation.tailrec
    def f(in: List[Int], n: Int, out: List[Int]): List[Int] =
      if (n == 1) in
      else in match {
        case x :: y :: z :: tail => if (x == y) {
          if (y == z) f(tail, n, out ::: List(3, x))
          else f(z :: tail, n, out ::: List(2, x))
        }
        else f(y :: z :: tail, n, out ::: List(1, x))
        case x :: y :: Nil => if (x == y) f(Nil, n, out ::: List(2, x)) else f(Nil, n, out ::: List(1, x, 1, y))
        case x :: Nil => f(Nil, n, out ::: List(1, x))
        case Nil => f(out, n - 1, Nil)
      }

    f(List(1), n, Nil).mkString
  }
}
