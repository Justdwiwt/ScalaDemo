package leetCode

object Solution_96 {
  def numTrees(n: Int): Int = {
    var res = 1L
    (n + 1 to 2 * n).foreach(i => res = res * i / (i - n))
    (res / (n + 1)).toInt
  }
}
