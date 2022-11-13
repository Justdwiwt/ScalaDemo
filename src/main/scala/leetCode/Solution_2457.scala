package leetCode

object Solution_2457 {
  def makeIntegerBeautiful(n: Long, target: Int): Long = {
    val isBeautiful = n.toString.map(_.asDigit).sum <= target

    if (isBeautiful) 0 else {
      val adding = 10 - n % 10
      makeIntegerBeautiful((n + adding) / 10, target) * 10 + adding
    }
  }
}
