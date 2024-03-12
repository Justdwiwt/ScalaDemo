package leetCode._500

object Solution_401 {
  def readBinaryWatch(num: Int): List[String] = {
    def f(n: Int): Int = n.toBinaryString.count(_ == '1')

    (0 until 12).flatMap(h => (0 until 60).filter(m => f(m) + f(h) == num).map(m => "%s:%02d".format(h.toString, m))).toList
  }
}
