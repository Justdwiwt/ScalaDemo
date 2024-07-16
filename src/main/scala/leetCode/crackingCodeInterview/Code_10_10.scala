package leetCode.crackingCodeInterview

object Code_10_10 {
  class StreamRank {
    private var list: List[Int] = Nil

    def track(x: Int): Unit =
      list = insertInOrder(list, x)

    def getRankOfNumber(x: Int): Int =
      rankOfNumber(list, x)

    private def insertInOrder(lst: List[Int], x: Int): List[Int] = lst match {
      case Nil => List(x)
      case head :: tail =>
        if (x <= head) x :: lst
        else head :: insertInOrder(tail, x)
    }

    private def rankOfNumber(lst: List[Int], x: Int): Int = {
      @scala.annotation.tailrec
      def binarySearch(target: Int, left: Int, right: Int): Int =
        if (left > right) left
        else {
          val mid = left + (right - left) / 2
          if (lst(mid) <= target) binarySearch(target, mid + 1, right)
          else binarySearch(target, left, mid - 1)
        }

      binarySearch(x, 0, lst.length - 1)
    }
  }
}
