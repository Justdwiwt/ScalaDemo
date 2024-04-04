package leetCode._600

object Solution_599 {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = List(list1, list2)
    .reduce(_.intersect(_))
    .groupBy(e => list1.indexOf(e) + list2.indexOf(e))
    ./:(Int.MaxValue -> Array[String]()) { case (min, p) => if (min._1 <= p._1) min else p }._2
}
