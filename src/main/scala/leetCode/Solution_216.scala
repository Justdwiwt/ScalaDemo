package leetCode

import scala.collection.mutable.ListBuffer

object Solution_216 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val res = ListBuffer[List[Int]]()
    val out = ListBuffer[Int]()
    dfs(k, n, 1, out, res)
    res.toList
  }

  def dfs(k: Int, n: Int, level: Int, out: ListBuffer[Int], res: ListBuffer[List[Int]]): Unit = {
    if (n < 0) return
    if (n == 0 && out.length == k) res.append(out.toList)
    (level to 9).foreach(i => {
      out.append(i)
      dfs(k, n - i, i + 1, out, res)
      out.dropRight(1)
    })
  }
}
