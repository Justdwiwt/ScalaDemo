package leetCode._3400

object Solution_3345 {
  def smallestNumber(n: Int, t: Int): Int = {
    def digitProduct(x: Int): Int =
      x.toString.map(_.asDigit).product

    @scala.annotation.tailrec
    def f(x: Int): Int =
      if (digitProduct(x) % t == 0) x
      else f(x + 1)

    f(n)
  }
}
