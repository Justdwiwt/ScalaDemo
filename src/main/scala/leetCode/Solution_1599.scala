package leetCode

object Solution_1599 {
  def minOperationsMaxProfit(customers: Array[Int], boardingCost: Int, runningCost: Int): Int = {
    var times = 0
    var total = 0
    var waiting = 0
    var max = 0
    var res = -1
    var i = 0

    while (waiting > 0 || i < customers.length) {
      if (i < customers.length) waiting += customers(i)
      i += 1
      val board = if (waiting <= 4) waiting else 4
      times += 1
      total += boardingCost * board - runningCost
      waiting -= board
      if (total > max) {
        max = total
        res = times
      }
    }
    if (max > 0) res else -1
  }
}
