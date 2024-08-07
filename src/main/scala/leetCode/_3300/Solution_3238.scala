package leetCode._3300

object Solution_3238 {
  def winningPlayerCount(n: Int, pick: Array[Array[Int]]): Int = {
    val cnt = Array.fill(n, 11)(0)
    pick.foreach { case Array(x, y) => cnt(x)(y) += 1 }
    cnt.zipWithIndex.count { case (cnt, i) => cnt.exists(_ > i) }
  }
}
