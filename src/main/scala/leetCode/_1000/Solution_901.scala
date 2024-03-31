package leetCode._1000

object Solution_901 {
  class StockSpanner() {
    var stack = List.empty[(Int, Int)]
    var day = 0

    def next(price: Int): Int = {
      day += 1
      while (stack.nonEmpty && stack.head._1 <= price) stack = stack.tail
      val res = if (stack.nonEmpty) day - stack.head._2 else day
      stack ::= price -> day
      res
    }
  }

}
