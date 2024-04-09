package leetCode._100

import scala.collection.mutable

object Solution_97 {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    def f(i: Int, j: Int, k: Int, dp: mutable.HashMap[(Int, Int), Boolean]): Boolean = (i == s1.length, j == s2.length) match {
      case (true, _) => s2.substring(j) == s3.substring(k)
      case (_, true) => s1.substring(i) == s3.substring(k)
      case _ => dp.getOrElseUpdate((i, j), ((s3(k) == s1(i)) && f(i + 1, j, k + 1, dp)) || ((s3(k) == s2(j)) && f(i, j + 1, k + 1, dp)))
    }

    (s1.length + s2.length == s3.length) && f(0, 0, 0, mutable.HashMap.empty[(Int, Int), Boolean])
  }
}
