package leetCode._500

object Solution_3476 {
  def maxProfit(workers: Array[Int], tasks: Array[Array[Int]]): Long = {
    val taskMap: Map[Int, List[Int]] = tasks
      .groupBy(_.head)
      .mapValues(_.map(_(1)).toList.sorted(Ordering[Int].reverse))

    val (finalMap, profitAssigned) = workers.foldLeft((taskMap, 0L)) {
      case ((map, total), worker) => map.get(worker) match {
        case Some(taskList) if taskList.nonEmpty =>
          val profit = taskList.head
          val updatedList = taskList.tail
          val newMap = if (updatedList.isEmpty) map - worker else map.updated(worker, updatedList)
          (newMap, total + profit)
        case _ => (map, total)
      }
    }

    val maxRemainProfit = finalMap.values.flatMap(_.headOption).reduceOption(_.max(_)).getOrElse(0)

    profitAssigned + maxRemainProfit
  }
}
