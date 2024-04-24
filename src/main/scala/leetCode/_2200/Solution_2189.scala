package leetCode._2200

object Solution_2189 {
  def houseOfCards(n: Int): Int = {
    val dp = (0 to n).foldLeft(Array.fill(n + 1)(0))((acc, num) => if (num == 0) acc.updated(num, 1) else acc)
    val res = (2 to n by 3).foldLeft(dp)((acc, num) => (n to num by -1).foldLeft(acc)((innerAcc, j) => innerAcc.updated(j, innerAcc(j) + innerAcc(j - num))))
    res(n)
  }
}
