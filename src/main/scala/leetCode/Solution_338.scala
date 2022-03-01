package leetCode

object Solution_338 {
  def countBits(n: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(in: Int, out: Int = 0): Int =
      if (in == 0) out
      else f(in >>> 1, out + (in & 1))

    def count(n: Int): Stream[Int] =
      f(n) #:: count(n + 1)

    count(0).take(n + 1).toArray
  }
}
