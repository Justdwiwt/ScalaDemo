package leetCode

object Solution_2683 {
  def doesValidArrayExist(derived: Array[Int]): Boolean =
    derived.reduce(_ ^ _) == 0
}
