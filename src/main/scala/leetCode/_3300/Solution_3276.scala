package leetCode._3300

import scala.collection.mutable

object Solution_3276 {
  def maxScore(grid: List[List[Int]]): Int = {
    val m = mutable.Map[Int, List[Int]]().withDefaultValue(Nil)
    grid.zipWithIndex.foreach { case (row, i) => row.toSet.foreach((x: Int) => m(x) = i :: m(x)) }
    val list = m.keys.toList
    val N = 1 << grid.length
    val arr = Array.fill(list.length + 1, N)(0)

    def f(i: Int): Array[Array[Int]] = (0 until N).foldLeft(arr)((curr, j) => {
      val res = curr.clone()
      res(i + 1)(j) = curr(i)(j)
      m(list(i)).foreach(k => if ((j >> k & 1) == 0) res(i + 1)(j) = res(i + 1)(j).max(curr(i)(j | (1 << k)) + list(i)))
      res
    })

    list.indices.foldLeft(arr)((_, i) => f(i))(list.length)(0)
  }
}
