package leetCode._1900

import scala.collection.mutable

object Solution_1883 {
  def minSkips(dist: Array[Int], speed: Int, hoursBefore: Int): Int = {
    if (dist.sum > speed * hoursBefore) return -1

    val m = mutable.Map.empty[(Int, Int), Int]

    def dfs(i: Int, j: Int): Int =
      if (j < 0) 0
      else m.getOrElseUpdate((i, j), {
        val res = (dfs(i, j - 1) + dist(j) + speed - 1) / speed * speed
        if (i > 0) res.min(dfs(i - 1, j - 1) + dist(j))
        else res
      })

    Stream.from(0).find(dfs(_, dist.length - 2) + dist.last <= speed * hoursBefore).getOrElse(-1)
  }
}
