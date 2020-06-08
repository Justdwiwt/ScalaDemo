package leetCode

object Solution_1375 {
  def numTimesAllBlue(light: Array[Int]): Int = {

    def f(y: Int, n: Int): Int = if (n == light.length || y == n + 1) 1 else 0

    @scala.annotation.tailrec
    def g(seq: Seq[Int], n: Int, y: Int, acc: Int): Int = if (seq.isEmpty) acc else g(seq.tail, n - 1, y.min(seq.head), f(y, n) + acc)

    g(light.reverse, light.length, light.length + 1, 0)
  }
}
