package leetCode._2300

import scala.collection.mutable

object Solution_2242 {
  def maximumScore(scores: Array[Int], edges: Array[Array[Int]]): Int = {
    val arr = Array.fill(scores.length)(mutable.ListBuffer.empty[Int])
    edges.foreach { case Array(x, y) =>
      arr(x).append(y)
      arr(y).append(x)
    }
    val reduce = arr.map(_.sortBy(scores).takeRight(3))

    val sequenceScores = edges
      .withFilter { case Array(_, _) => true; case _ => false }
      .flatMap { case Array(x, y) => reduce(x)
        .flatMap(nx => reduce(y)
          .withFilter(ny => nx != ny && nx != y && x != ny)
          .map(ny => scores(nx) + scores(x) + scores(y) + scores(ny))
        )
      }

    if (sequenceScores.isEmpty) -1 else sequenceScores.max
  }
}
