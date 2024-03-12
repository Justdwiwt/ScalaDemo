package leetCode._1400

import scala.collection.mutable

object Solution_1340 {

  class Cache[A, B] {
    val m = new mutable.HashMap[A, B]()

    def cache(f: A => B, input: A): B = {
      if (m.contains(input)) m(input)
      else {
        m.put(input, f(input))
        m(input)
      }
    }
  }

  def maxJumps(arr: Array[Int], d: Int): Int = {
    val cache = new Cache[Int, Int]()

    def dp(i: Int): Int = {
      (Seq(1) ++ (i - 1 to i - d by -1)
        .takeWhile(x => x >= 0 && arr(x) < arr(i))
        .map(x => 1 + cache.cache(dp, x)) ++ (i + 1 to i + d)
        .takeWhile(x => x < arr.length && arr(x) < arr(i))
        .map(x => 1 + cache.cache(dp, x))).max
    }

    arr.indices.sortBy(i => arr(i)).map(dp).max
  }
}
