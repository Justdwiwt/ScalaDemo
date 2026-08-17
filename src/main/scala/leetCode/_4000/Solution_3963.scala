package leetCode._4000

object Solution_3963 {
  def createGrid(m: Int, n: Int): Array[String] =
    if (n == 1) Array.fill(m)(".")
    else Array.fill(m - 1)(".#" + Array.fill(n - 2)("#").mkString) :+ Array.fill(n)(".").mkString
}
