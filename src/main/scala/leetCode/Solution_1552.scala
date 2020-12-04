package leetCode

object Solution_1552 {
  def maxDistance(position: Array[Int], m: Int): Int = {
    val sorted = position.sorted
    val mx = sorted(sorted.length - 1) - sorted.head
    var mn = Int.MaxValue
    if (m == 2) return mx
    sorted.indices.drop(1).foreach(i => mn = mn.min(sorted(i) - sorted(i - 1)))
    var l = mn
    var r = mx
    while (l < r) {
      val mid = (l + r) >> 1
      if (check(sorted, mid) >= m) l = mid + 1
      else r = mid
    }
    l
  }

  def check(pos: Array[Int], m: Int): Int = {
    var num = 1
    var head = pos.head
    pos.indices.drop(1).foreach(i => if (pos(i) - head > m) {
      num += 1
      head = pos(i)
    })
    num
  }
}
