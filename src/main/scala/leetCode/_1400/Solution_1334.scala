package leetCode._1400

object Solution_1334 {
  def findTheCity(N: Int, edges: Array[Array[Int]], distanceThreshold: Int): Int = {
    val arr = Array.fill(N, N)(Int.MaxValue)
    edges.foreach { case Array(i, j, w) =>
      arr(i)(j) = w
      arr(j)(i) = w
    }
    (0 until N).foreach(k => (0 until N).foreach(i => (0 until N)
      .withFilter(j => i != j && arr(i)(k) != Int.MaxValue && arr(k)(j) != Int.MaxValue)
      .foreach(j => arr(i)(j) = arr(i)(j).min(arr(i)(k) + arr(k)(j)))
    ))
    arr.map(_.count(_ <= distanceThreshold)).zipWithIndex.reverse.minBy(_._1)._2
  }
}
