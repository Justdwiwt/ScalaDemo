package leetCode._3600

object Solution_3527 {
  def findCommonResponse(responses: List[List[String]]): String = {
    val list = responses.foldLeft(collection.mutable.HashMap[String, Int]()) {
      case (map, row) =>
        row.toSet.foreach(value => map += value -> (map.getOrElse(value, 0) + 1))
        map
    }.toList
    val max = list.maxBy(_._2)._2
    list.filter(_._2 == max).minBy(_._1)._1
  }
}
