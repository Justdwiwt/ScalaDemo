package leetCode._2500

object Solution_2418 {
  def sortPeople(names: Array[String], heights: Array[Int]): Array[String] = names
    .zip(heights)
    .sortBy(-_._2)
    .map(_._1)
}
