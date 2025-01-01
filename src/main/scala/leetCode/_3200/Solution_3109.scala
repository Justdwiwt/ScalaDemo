package leetCode._3200

import scala.collection.Searching._

object Solution_3109 {
  val M = 1000000007L
  val fact: Array[Long] = Array.ofDim[Long](100001)
  fact(0) = 1L
  fact(1) = 1L
  (2 to 100000).foreach(p => fact(p) = (fact(p - 1) * p) % M)

  def getPermutationIndex(perm: Array[Int]): Int = {
    val n = perm.length
    val tmp = (1 to n).toBuffer
    var res = 0L
    perm.indices.foreach(i => {
      val b = tmp.search(perm(i)).insertionPoint
      res += fact(n - 1 - i) * b
      tmp.remove(b)
    })
    (res % M).toInt
  }
}
