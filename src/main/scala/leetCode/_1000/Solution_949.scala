package leetCode._1000

object Solution_949 {
  def largestTimeFromDigits(A: Array[Int]): String = {
    def first(i: Int): Boolean =
      i >= 0 && i <= 2

    def second(i: Int, prev: Int): Boolean =
      if (prev == 2) i >= 0 && i <= 3
      else true

    def third(i: Int): Boolean =
      i >= 0 && i <= 5

    A
      .permutations
      .filter(p => first(p(0)) && second(p(1), p(0)) && third(p(2)))
      .map(_.mkString)
      .toStream
      .sortWith(_ > _)
      .headOption match {
      case None => ""
      case Some(date) => date.take(2) + ":" + date.drop(2)
    }
  }
}
