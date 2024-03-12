package leetCode._500

import scala.collection.mutable

object Solution_481 {
  def magicalString(n: Int): Int =
    if (n == 0) 0
    else if (n < 4) 1
    else f(n - 2, mutable.Queue(2), 1)

  @scala.annotation.tailrec
  def f(n: Int, q: mutable.Queue[Int], res: Int): Int =
    if (n == 1) res
    else {
      val nx = 3 - q.last
      val v = q.dequeue()
      if (n == 2) res + (2 - nx)
      else {
        q += nx
        if (v == 2) q += nx
        f(n - v, q, res + v * (2 - nx))
      }
    }
}
