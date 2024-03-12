package leetCode._2000

object Solution_1925 {
  def countTriples(n: Int): Int = {
    val m = Array.tabulate(251)(i => i * i -> i).toMap
    var res = 0
    (1 to n).foreach(i => (1 to n).foreach(j => if (m.contains(i * i + j * j) && m(i * i + j * j) <= n) res += 1))
    res
  }
}
