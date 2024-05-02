package leetCode._1100

import scala.collection.mutable

object Solution_1086 {
  def highFive(items: Array[Array[Int]]): Array[Array[Int]] = {
    val sortedItems = items.sortBy(item => (item.head, -item(1)))

    val scoresMap = mutable.Map.empty[Int, (Int, Int)]

    sortedItems
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(id, score) =>
        scoresMap.get(id) match {
          case Some((sum, count)) if count < 5 => scoresMap(id) = (sum + score, count + 1)
          case None => scoresMap(id) = (score, 1)
          case _ =>
        }
      }

    scoresMap.map { case (id, (sum, count)) => Array(id, sum / count) }.toArray.sortBy(_.head)
  }
}
