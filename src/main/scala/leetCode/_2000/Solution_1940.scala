package leetCode._2000

import scala.collection.mutable

object Solution_1940 {
  def longestCommonSubsequence(arrays: Array[Array[Int]]): List[Int] = {
    val counts = mutable.Map.empty[Int, Int].withDefaultValue(0)
    arrays.flatten.foreach(counts(_) += 1)
    counts.filter { case (_, count) => count == arrays.length }.keys.toList.sorted
  }
}
