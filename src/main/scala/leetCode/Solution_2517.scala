package leetCode

object Solution_2517 {
  def maximumTastiness(price: Array[Int], k: Int): Int = {
    val sorted = price.sorted
    val mx = sorted(sorted.length - 1) - sorted.head
    var mn = Int.MaxValue
    if (k == 2) return mx
    sorted.indices.drop(1).foreach(i => mn = mn.min(sorted(i) - sorted(i - 1)))
    var l = mn
    var r = mx
    while (l < r) {
      val mid = (l + r) >> 1
      if (check(sorted, mid) >= k) l = mid + 1
      else r = mid
    }
    l
  }

  private def check(pos: Array[Int], m: Int): Int = {
    var num = 1
    var head = pos.head
    pos.indices.drop(1).foreach(i => if (pos(i) - head > m) {
      num += 1
      head = pos(i)
    })
    num
  }
}
