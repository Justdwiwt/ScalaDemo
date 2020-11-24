package leetCode

object Solution_1647 {
  def minDeletions(s: String): Int = {
    var res = 0
    val cnt = Array.fill(26)(0)
    s.foreach(i => cnt.update(i - 'a', cnt(i - 'a') + 1))
    val sorted = cnt.sorted.reverse
    sorted.indices.foreach(i => if (sorted(i) != 0 && i > 0) {
      while (sorted(i) >= sorted(i - 1) && sorted(i) > 0) {
        sorted.update(i, sorted(i) - 1)
        res += 1
      }
    })
    res
  }
}
