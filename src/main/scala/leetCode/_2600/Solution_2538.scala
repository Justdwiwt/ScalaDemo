package leetCode._2600

import scala.collection.mutable.ArrayBuffer

object Solution_2538 {
  private var g: Array[ArrayBuffer[Int]] = _
  private var price: Array[Int] = _
  private var ans: Long = _

  def maxOutput(n: Int, edges: Array[Array[Int]], price: Array[Int]): Long = {
    this.price = price
    g = Array.fill(n)(ArrayBuffer.empty[Int])
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x).append(y)
      g(y).append(x)
    })
    ans = 0
    dfs(0, -1)
    ans
  }

  private def dfs(x: Int, fa: Int): Array[Long] = {
    val p = price(x)
    var maxS1 = p
    var maxS2 = 0
    g(x).foreach(y => if (y != fa) {
      val res = dfs(y, x)
      val s1 = res.head
      val s2 = res(1)
      ans = ans.max(maxS1 + s2).max(maxS2 + s1)
      maxS1 = maxS1.max((s1 + p).toInt)
      maxS2 = maxS2.max((s2 + p).toInt)
    })
    Array(maxS1.toLong, maxS2.toLong)
  }
}
