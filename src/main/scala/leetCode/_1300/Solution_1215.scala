package leetCode._1300

import scala.collection.mutable.ListBuffer

object Solution_1215 {
  def countSteppingNumbers(low: Int, high: Int): List[Int] = {
    val res = ListBuffer.empty[Int]
    if (low == 0) res += 0
    (1 to 9).foreach(dfs(res, _, low, high))
    res.toList.sorted
  }

  private def dfs(res: ListBuffer[Int], cur: Int, low: Int, high: Int): Unit = {
    if (cur >= low && cur <= high) res += cur
    if (cur > high / 10) return
    val r = cur % 10
    if (r != 9 && cur * 10 + r + 1 <= high) dfs(res, cur * 10 + r + 1, low, high)
    if (r != 0 && cur * 10 + r - 1 <= high) dfs(res, cur * 10 + r - 1, low, high)
  }
}
