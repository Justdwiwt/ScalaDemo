package leetCode

import scala.collection.mutable

object Solution_1792 {
  private implicit val ClassOrdering: Ordering[Array[Int]] = Ordering.by {
    case Array(pass, total) => (total - pass).toDouble / total / (total + 1)
  }

  def maxAverageRatio(classes: Array[Array[Int]], extraStudents: Int): Double = {
    val pq = mutable.PriorityQueue(classes: _*)

    (1 to extraStudents).foreach(_ => pq.dequeue match {
      case Array(pass, total) => pq.enqueue(Array(pass + 1, total + 1))
    })

    pq.iterator.collect { case Array(pass, total) => pass.toDouble / total }.sum / classes.length
  }
}
