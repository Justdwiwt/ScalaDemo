package leetCode._3700

object Solution_3675 {
  def minOperations(s: String): Int = {
    val sorted = s.toList.distinct.sorted
    val list = if (sorted.head == 'a') sorted.tail.reverse else sorted.reverse
    (('z'.asNum + 1) :: list.map(_.asNum)).sliding(2).map(v => v.head - v.last).sum
  }

  implicit class ToNum(c: Char) {
    def asNum: Int = c - 'a'
  }
}
