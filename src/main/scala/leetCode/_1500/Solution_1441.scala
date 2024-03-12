package leetCode._1500

object Solution_1441 {
  def buildArray(target: Array[Int], n: Int): List[String] = (1 until n.min(target.max) + 1)
    .toList
    .flatMap(x => if (target.contains(x)) Array("Push") else Array("Push", "Pop"))
}
