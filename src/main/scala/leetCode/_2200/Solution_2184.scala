package leetCode._2200

import scala.collection.mutable.ListBuffer

object Solution_2184 {
  private def dfs(bricks: Array[Int], width: Int, len: Int, s: Int, list: ListBuffer[Int]): Unit =
    if (width == 0) list += (s ^ (1 << len))
    else bricks.foreach(brick => if (brick <= width) dfs(bricks, width - brick, len + brick, s | (1 << (len + brick)), list))

  def buildWall(height: Int, width: Int, bricks: Array[Int]): Int = {
    val M = 1000000007
    val list = ListBuffer.empty[Int]
    dfs(bricks, width, 0, 0, list)

    val m = list.length
    val lists = Array.fill[ListBuffer[Int]](m)(ListBuffer[Int]())
    list.indices.foreach(i => {
      val a = list(i)
      list.indices.foreach(j => {
        val b = list(j)
        if ((a & b) > 0) ()
        else lists(i) += j
      })
    })

    val dp = Array.ofDim[Long](height + 1, m)
    dp(1) = Array.fill[Long](m)(1)
    (1 until height).foreach(i => list.indices.foreach(j => lists(j).foreach(k => dp(i + 1)(k) = (dp(i + 1)(k) + dp(i)(j)) % M)))

    list.indices.foldLeft(0L)((acc, i) => (acc + dp(height)(i)) % M).toInt
  }
}
