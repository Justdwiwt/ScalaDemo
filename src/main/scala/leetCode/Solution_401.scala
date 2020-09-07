package leetCode

object Solution_401 {
  def readBinaryWatch(num: Int): List[String] = {
    def f(n: Int): Int = n.toBinaryString.filter(_ == '1').length

    (0 until 12).flatMap(h => (0 until 60).filter(m => f(m) + f(h) == num).map(m => h.toString + ":" + "%02d".format(m))).toList
  }
}
