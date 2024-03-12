package leetCode._2700

object Solution_2683 {
  def doesValidArrayExist(derived: Array[Int]): Boolean =
    derived.reduce(_ ^ _) == 0
}
