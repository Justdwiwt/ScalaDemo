package leetCode._2300

object Solution_2217 {
  def kthPalindrome(queries: Array[Int], intLength: Int): Array[Long] = {
    val arr = Iterator.fill((intLength - 1) / 2)(10L).product
    queries.map(x => if (x > arr * 9) -1 else (arr + x - 1).toString match {
      case s => (s.dropRight(intLength & 1) ++ s.reverse).toLong
    })
  }
}
