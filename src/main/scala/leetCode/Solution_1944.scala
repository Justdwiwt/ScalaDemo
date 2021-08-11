package leetCode

object Solution_1944 {
  def canSeePersonsCount(heights: Array[Int]): Array[Int] = heights
    .reverse
    ./:((List.empty[Int], List.empty[Int])) { case ((st, res), e) =>
      def f(l: List[Int]): Int = l match {
        case Nil => 0
        case head :: tail => if (head < e) 1 + f(tail) else 1
      }

      (e :: st.dropWhile(_ < e), f(st) :: res)
    }
    ._2
    .toArray
}
