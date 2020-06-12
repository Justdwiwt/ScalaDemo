package leetCode

object Solution_1317 {
  def getNoZeroIntegers(n: Int): Array[Int] = {

    @scala.annotation.tailrec
    def f(num: Int): Boolean = num match {
      case 0 => true
      case _ => if (num % 10 == 0) false else f(num / 10)
    }

    (1 until n).foreach(i => if (f(i) && f(n - i)) return Array(i, n - i))
    Array.empty
  }
}
