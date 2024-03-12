package leetCode._1900

object Solution_1823 {
  def findTheWinner(n: Int, k: Int): Int = {
    var res = 0
    (2 to n).foreach(i => res = (res + k) % i)
    res + 1
  }
}
