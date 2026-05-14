package leetCode._3900

object Solution_3883 {
  private val MOD = 1000000007
  private val MX = 5001

  def countArrays(digitSum: Array[Int]): Int = {
    val digSum = Array.tabulate(MX)(_.toString.map(_ - '0').sum)

    if (digitSum.exists(_ > 31)) 0
    else digitSum
      .foldLeft(Array.fill(MX)(1L)) { (s, ds) =>
        s.indices.foldLeft(0L -> Array.ofDim[Long](MX)) {
          case ((pre, nxt), x) =>
            val cur =
              if (digSum(x) == ds) (pre + s(x)) % MOD
              else pre

            nxt(x) = cur
            cur -> nxt
        }._2
      }
      .last
      .toInt
  }
}
