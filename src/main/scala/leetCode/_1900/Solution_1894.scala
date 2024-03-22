package leetCode._1900

object Solution_1894 {
  def chalkReplacer(ch: Array[Int], _k: Int): Int = {
    val cumulativeSums = ch.scanLeft(0L)(_ + _)
    cumulativeSums
      .tail
      .zipWithIndex
      .collectFirst {
        case (cumulativeSum, student) if cumulativeSum > (_k % cumulativeSums.last) => student
      }
      .get
  }
}
