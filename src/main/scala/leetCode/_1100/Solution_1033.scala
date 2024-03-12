package leetCode._1100

object Solution_1033 {
  def numMovesStones(a: Int, b: Int, c: Int): Array[Int] = {
    val diff = Array(a, b, c).sorted
    val res = Array.fill(2)(0)
    if (diff(1) - diff(0) == 1 && diff(2) - diff(1) == 1) res(0) = 0
    else if (diff(1) - diff(0) == 1 || diff(2) - diff(1) == 1 || diff(2) - diff(1) == 2 || diff(1) - diff(0) == 2) res(0) = 1
    else res(0) = 2
    res(1) = diff(2) - diff(0) - 2
    res
  }
}
