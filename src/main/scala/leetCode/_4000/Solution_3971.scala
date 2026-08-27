package leetCode._4000

object Solution_3971 {
  def maxTotalValue(value: Array[Int], decay: Array[Int], m: Int): Int = {
    def check(low: Long): Boolean = value
      .zip(decay)
      .scanLeft(m) {
        case (left, (v, d)) if v >= low => left - ((v - low) / d + 1).toInt
        case (left, _) => left
      }
      .exists(_ < 0)

    val low =
      if (!check(0)) 0L
      else {
        @scala.annotation.tailrec
        def search(left: Long, right: Long): Long =
          if (left + 1 >= right) left
          else {
            val mid = (left + right) / 2
            if (check(mid)) search(mid, right)
            else search(left, mid)
          }

        search(0, value.max.toLong + 1)
      }

    val (remaining, sum) = value.zip(decay).foldLeft((m, 0L)) {
      case ((left, sum), (v, d)) if v > low =>
        val k = (v - low - 1) / d + 1

        (left - k.toInt, sum + (v * 2L - d * (k - 1)) * k)

      case (state, _) => state
    }

    ((sum / 2 + remaining * low) % 1000000007).toInt
  }
}
