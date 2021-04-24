package leetCode

object Solution_1833 {
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    var res = 0
    costs.sorted./:(coins)((l, i) =>
      if (l >= i) {
        res += 1
        l - i
      } else return res
    )
    res
  }
}
