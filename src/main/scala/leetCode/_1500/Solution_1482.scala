package leetCode._1500

object Solution_1482 {
  def minDays(bloomDay: Array[Int], m: Int, k: Int): Int = {
    if (k * m > bloomDay.length) return -1
    f(bloomDay, m, k, 1, bloomDay.max)._3
  }

  @scala.annotation.tailrec
  def f(bloomDay: Array[Int], m: Int, k: Int, left: Int, right: Int): (Int, Int, Int) = {
    if (left >= right && isDayOkay(bloomDay, m, k, left)) return (0, 0, left)
    if (left >= right) return (0, 0, bloomDay.max)
    val mid = (left + right) >>> 1
    if (isDayOkay(bloomDay, m, k, mid)) f(bloomDay, m, k, left, mid)
    else f(bloomDay, m, k, mid + 1, right)
  }

  def isDayOkay(bloomDay: Array[Int], m: Int, k: Int, currDay: Int): Boolean = bloomDay./:((m, k)) {
    case ((0, _), _) => (0, 0)
    case ((cur, _), d) if d > currDay => (cur, k)
    case ((cur, currK), _) if currK > 1 => (cur, currK - 1)
    case ((cur, 1), _) => (cur - 1, k)
    case ((cur, currK), _) => (cur, currK)
  }._1 == 0
}
