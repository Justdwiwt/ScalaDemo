package leetCode

import scala.collection.mutable

object Solution_1423 {

  class Cache[A, B] {
    private val m = mutable.HashMap[A, B]()

    def cache(f: A => B, input: A): B = {
      if (m.contains(input)) m(input)
      else {
        m.put(input, f(input))
        m(input)
      }
    }
  }

  def maxScore(A: Array[Int], k: Int): Int = {
    val cache = new Cache[Int, Int]()

    def f(x: Int): Int = if (x < 0) 0 else A(x) + cache.cache(f, x - 1)

    def g(x: Int, y: Int): Int = f(y) - f(x - 1)

    A.sum - A.indices.map(i => {
      val t = i + A.length - k - 1
      (i, t)
    }).withFilter({ case (_, v) => v < A.length })
      .map({ case (i, v) => g(i, v) }).min
  }

}
