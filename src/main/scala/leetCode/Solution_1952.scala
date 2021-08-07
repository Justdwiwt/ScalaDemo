package leetCode

object Solution_1952 {
  def isThree(n: Int): Boolean =
    (2 to n).count(n % _ == 0) == 2
}
