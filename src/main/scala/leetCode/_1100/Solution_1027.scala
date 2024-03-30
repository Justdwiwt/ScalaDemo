package leetCode._1100

import scala.collection.mutable

object Solution_1027 {
  def longestArithSeqLength(arr: Array[Int]): Int = {
    arr.indices.foldLeft(Array.ofDim[mutable.HashMap[Int, Int]](arr.length))((b, i) => {
      b(i) = mutable.HashMap[Int, Int]()
      (0 until i).foreach(j => {
        val d = arr(i) - arr(j)
        b(i).put(d, b(j).getOrElse(d, 1) + 1)
      })
      b
    }).filter(n => n.nonEmpty).flatMap(n => n.values).max
  }
}
