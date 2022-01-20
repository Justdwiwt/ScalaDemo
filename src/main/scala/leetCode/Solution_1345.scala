package leetCode

import scala.collection.mutable

object Solution_1345 {
  def minJumps(arr: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    arr.indices.foreach(i => m(arr(i)) = i :: m(arr(i)))
    val visited = Array.fill(arr.length)(false)
    visited(0) = true
    val q = mutable.Queue[Int](0)
    arr.indices.foreach(step =>
      q.indices.foreach(_ => {
        val x = q.dequeue()
        if (x == arr.length - 1) return step
        if (x - 1 > 0 && !visited(x - 1)) {
          q += x - 1
          visited(x - 1) = true
        }
        (x + 1 :: m(arr(x)))
          .withFilter(j => !visited(j))
          .foreach(j => {
            q += j
            visited(j) = true
          })
        m.remove(arr(x))
      }))
    arr.length
  }
}
