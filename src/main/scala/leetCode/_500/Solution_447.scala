package leetCode._500

object Solution_447 {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    var cnt = 0
    points.indices.foreach(i => {
      val distances = scala.collection.mutable.Map.empty[Int, Int]
      points
        .indices
        .withFilter(_ != i)
        .foreach(j => {
          val dist = distance(points(i), points(j))
          distances(dist) = distances.getOrElse(dist, 0) + 1
        })
      distances.foreach(freq => cnt += freq._2 * (freq._2 - 1))
    })
    cnt
  }

  private def distance(x: Array[Int], y: Array[Int]): Int =
    (x.head - y.head) * (x.head - y.head) + (x(1) - y(1)) * (x(1) - y(1))
}
