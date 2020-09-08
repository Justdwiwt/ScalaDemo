package leetCode

object Solution_621 {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val cnt = Array.ofDim[Int](26)
    var mx = 0
    tasks.foreach(i => {
      cnt(i - 'A') += 1
      mx = mx.max(cnt(i - 'A'))
    })
    var res = (mx - 1) * (n + 1)
    (0 until 26).foreach(i => if (cnt(i) == mx) res += 1)
    res.max(tasks.length)
  }
}
