package leetCode._1500

object Solution_1414 {
  implicit class RichInt(i: Int) {
    def toFib(x: Int, y: Int, acc: List[Int]): List[Int] =
      if (x > i) acc else toFib(y, x + y, x :: acc)

    def minNum(fibList: List[Int], res: Int): Int = fibList match {
      case _ if i == 0 => res
      case h :: tails if h > i => minNum(tails, res)
      case h :: tails => (i - h).minNum(tails, res + 1)
      case _ => res
    }
  }

  def findMinFibonacciNumbers(k: Int): Int =
    k.minNum(k.toFib(0, 1, Nil), 0)
}
