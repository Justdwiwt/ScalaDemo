package leetCode

object Solution_1817 {
  def findingUsersActiveMinutes(logs: Array[Array[Int]], k: Int): Array[Int] = {
    val res = Array.fill(k)(0)
    logs
      .map({ case Array(v1, v2) => (v1, v2) })
      .toSeq
      .groupBy(_._1)
      .mapValues(seq => seq.map(_._2))
      .mapValues(_.toSet.size)
      .groupBy(_._2)
      .mapValues(_.toMap)
      .mapValues(_.keySet.size)
      .foreach(entry => res(entry._1 - 1) = entry._2)
    res
  }
}
