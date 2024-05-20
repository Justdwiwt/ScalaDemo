package leetCode._3200

object Solution_3153 {
  def sumDigitDifferences(nums: Array[Int]): Long = {
    def f(counters: Vector[Vector[Int]], x: Int, k: Int): (Vector[Vector[Int]], Long) = x
      .toString
      .reverse
      .zipWithIndex
      .foldLeft((counters, 0L)) {
        case ((cur, acc), (ch, i)) =>
          val d = ch.asDigit
          val newCnt = cur.updated(i, cur(i).updated(d, cur(i)(d) + 1))
          (newCnt, acc + k - cur(i)(d))
      }

    val maxDigits = nums.map(_.toString.length).max
    val initialCounters = Vector.fill(maxDigits)(Vector.fill(10)(0))

    nums.zipWithIndex.foldLeft((initialCounters, 0L)) {
      case ((counters, total), (num, idx)) =>
        val (newCounters, increment) = f(counters, num, idx)
        (newCounters, total + increment)
    }._2
  }
}
