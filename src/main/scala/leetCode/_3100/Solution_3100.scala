package leetCode._3100

object Solution_3100 {
  def maxBottlesDrunk(numBottles: Int, numExchange: Int): Int = {
    @scala.annotation.tailrec
    def f(bottles: Int, exchange: Int, ans: Int): Int =
      if (bottles < exchange) ans
      else {
        val newAns = ans + 1
        val newBottles = bottles - exchange + 1
        f(newBottles, exchange + 1, newAns)
      }

    f(numBottles, numExchange, numBottles)
  }
}
