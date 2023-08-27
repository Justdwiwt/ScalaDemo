package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_2830 {
  def maximizeTheProfit(n: Int, offers: List[List[Int]]): Int = {
    val groups: Array[ArrayBuffer[Array[Int]]] = Array.fill(n)(ArrayBuffer.empty)
    offers.foreach(offer => groups(offer(1)) += Array(offer.head, offer(2)))
    val arr = Array.ofDim[Int](n + 1)
    (0 until n).foreach(end => {
      arr(end + 1) = arr(end)
      groups(end).foreach(p => arr(end + 1) = arr(end + 1).max(arr(p.head) + p(1)))
    })
    arr(n)
  }
}
