package leetCode._1400

object Solution_1317 {
  def getNoZeroIntegers(n: Int): Array[Int] = {
    def findZero(num: Int): Boolean =
      num.toString.contains("0")

    val a = (1 until n).find(i => !findZero(i) && !findZero(n - i)).get
    Array(a, n - a)
  }
}
