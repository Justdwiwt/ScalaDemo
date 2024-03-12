package leetCode._1500

object Solution_1403 {
  def minSubsequence(A: Array[Int]): List[Int] = {
    val list = A.sorted.reverse.toList
    val sum = list.sum

    @scala.annotation.tailrec
    def f(list: List[Int], cur: Int, acc: List[Int]): List[Int] = list match {
      case Nil => acc.reverse
      case h :: t => if (cur + h > sum / 2) (h :: acc).reverse else f(t, cur + h, h :: acc)
    }

    f(list, 0, Nil)
  }
}
