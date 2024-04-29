package leetCode._1600

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1548 {
  def mostSimilar(n: Int, roads: Array[Array[Int]], names: Array[String], targetPath: Array[String]): List[Int] = {
    val graph = Array.ofDim[Boolean](n, n)
    roads.foreach(r => {
      val u = r.head
      val v = r(1)
      graph(u)(v) = true
      graph(v)(u) = true
    })

    val minCost = Array.ofDim[Int](targetPath.length, n)
    val lastCity = Array.ofDim[Int](targetPath.length, n)
    val firstCityIndexes = mutable.HashSet.empty[Int]

    names.indices.foreach(i => if (targetPath.head.equals(names(i))) firstCityIndexes.add(i))

    java.util.Arrays.fill(minCost.head, Int.MaxValue)
    java.util.Arrays.fill(lastCity.head, -1)

    (0 until n).foreach(cur =>
      if (firstCityIndexes.contains(cur) && names(cur).equals(targetPath.head)) minCost.head(cur) = 0
      else minCost.head(cur) = 1
    )

    minCost.indices.drop(1).foreach(i => (0 until n).foreach(cur => {
      var min = Int.MaxValue
      lastCity(i)(cur) = -1
      (0 until n).foreach(prev =>
        if (!graph(cur)(prev)) ()
        else if (min > minCost(i - 1)(prev)) {
          min = minCost(i - 1)(prev)
          lastCity(i)(cur) = prev
        })
      if (min < Int.MaxValue) min += (if (names(cur).equals(targetPath(i))) 0 else 1)
      minCost(i)(cur) = min
    }))

    var minIndex = 0
    (1 until n).foreach(i => if (minCost(targetPath.length - 1)(i) < minCost(targetPath.length - 1)(minIndex)) minIndex = i)

    val res = ListBuffer.empty[Int]
    var i = targetPath.length - 1
    while (minIndex >= 0) {
      res.prepend(minIndex)
      minIndex = lastCity(i)(minIndex)
      i -= 1
    }
    res.toList
  }
}
