package leetCode

object Solution_2652 {
  def sumOfMultiples(n: Int): Int = {
    var res = 0
    (1 to n).foreach(i => if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) res += i)
    res
  }
}
