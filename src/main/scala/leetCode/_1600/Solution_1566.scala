package leetCode._1600

object Solution_1566 {
  def containsPattern(arr: Array[Int], m: Int, k: Int): Boolean = {
    var cnt = 0
    (m until arr.length).withFilter(_ => cnt < m * (k - 1)).foreach(i => cnt = if (arr(i) == arr(i - m)) cnt + 1 else 0)
    cnt == m * (k - 1)
  }
}
