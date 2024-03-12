package leetCode._1700

object Solution_1611 {
  def minimumOneBitOperations(n: Int): Int = {
    @scala.annotation.tailrec
    def f(v: Int, acc: Int): Int = {
      if (v == 0) acc
      else {
        var b = 1
        while ((b << 1) <= v) b = b << 1
        f(b ^ (b >> 1) ^ v, acc + b)
      }
    }

    f(n, 0)
  }
}
