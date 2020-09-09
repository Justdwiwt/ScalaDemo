package leetCode

object Solution_880 {
  def decodeAtIndex(S: String, K: Int): String = {
    @scala.annotation.tailrec
    def f(size: Long, S: String, K: Long): String = S.head match {
      case digit if digit.isDigit => f(size / (digit - '0'), S.tail, K % size)
      case ch if K % size == 0 => ch.toString
      case _ => f(size - 1, S.tail, K % size)
    }

    f(S.foldLeft(0L)((size, curr) => if (curr.isDigit) size * (curr - '0') else size + 1), S.reverse, K.toLong)
  }
}
