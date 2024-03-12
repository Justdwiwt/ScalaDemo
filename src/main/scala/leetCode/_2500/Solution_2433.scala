package leetCode._2500

object Solution_2433 {
  def findArray(pref: Array[Int]): Array[Int] = (0 +: pref)
    .sliding(2)
    .map(_.reduce(_ ^ _))
    .toArray
}
