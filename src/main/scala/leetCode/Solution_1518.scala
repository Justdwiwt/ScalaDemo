package leetCode

object Solution_1518 {
  def numWaterBottles(numBottles: Int, numExchange: Int): Int = {
    numBottles + numBottles / (numExchange - 1) - (if (numBottles % (numExchange - 1) == 0) 1 else 0)
  }
}
