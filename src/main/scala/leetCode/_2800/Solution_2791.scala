package leetCode._2800

import scala.collection.mutable
//import scala.util.chaining.*

object Solution_2791 {
  def countPalindromePaths(parent: List[Int], s: String): Long = {
    val parents = parent.toArray

    val m = mutable.Map.empty[Int, Int]

    def mask(i: Int): Int = m
      .getOrElseUpdate(i, if (i == 0) 0 else mask(parents(i)) ^ (1 << s(i) - 'a'))

    parents
      .indices
      .foldLeft(0L, Map.empty[Int, Int].withDefaultValue(0)) { case ((res, cnt), i) =>
        val newRes = (0 until 26).foldLeft(res)((res, j) => res + cnt(mask(i) ^ (1 << j)))
        (newRes + cnt(mask(i)), cnt.updated(mask(i), cnt(mask(i)) + 1))
      }
      //      .pipe { case (res, _) => res }
      ._1
  }
}
