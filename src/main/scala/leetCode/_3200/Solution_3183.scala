package leetCode._3200

object Solution_3183 {
  private val M: Int = 1000000007

  private def dfs(i: Int, last: Int, four: Int, cache: Map[(Int, Int, Int), Int]): (Int, Map[(Int, Int, Int), Int]) = {
    if (i == 0) return (1, cache)
    if (i < 0) return (0, cache)

    val key = (i, last, four)
    if (cache.contains(key)) return (cache(key), cache)

    val (res1, cache1) =
      if (four > 0 && last <= 4) {
        val (ans, updatedCache) = dfs(i - 4, 4, four - 1, cache)
        (ans, updatedCache)
      } else (0, cache)

    val (res2, finalCache) = List(1, 2, 6).foldLeft((0, cache1)) {
      case ((acc, cache), j) =>
        if (j >= last) {
          val (ans, updatedCache) = dfs(i - j, j, four, cache)
          ((acc + ans) % M, updatedCache)
        } else (acc, cache)
    }

    val res = (res1 + res2) % M
    (res, finalCache + (key -> res))
  }

  val pre: Array[Int] = {
    val initCache = Map.empty[(Int, Int, Int), Int]
    (1 until 100001).foldLeft((Array.fill(100001)(0), initCache)) {
      case ((preArr, cache), m) =>
        val (result, updatedCache) = dfs(m, 1, 2, cache)
        preArr(m) = result
        (preArr, updatedCache)
    }._1
  }

  def numberOfWays(n: Int): Int =
    pre(n)
}
