package leetCode.offer

object Offer_57_2 {
  def p(x: Int, y: Int): Array[Int] = (x to y).toArray

  def g(x: Array[Int], l: List[Array[Int]]): List[Array[Int]] = if (x.length == 1) l else x :: l

  def findContinuousSequence(k: Int): Array[Array[Int]] = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int, cur: Int, acc: List[Array[Int]]): List[Array[Int]] = if (l > k || r > k) acc else {
      if (cur == k) f(l + 1, r, cur - l, g(p(l, r), acc))
      else if (cur < k) f(l, r + 1, cur + r + 1, acc)
      else f(l + 1, r, cur - l, acc)
    }

    f(1, 1, 1, Nil).reverse.toArray
  }
}
