package leetCode

import scala.collection.mutable

object Solution_901 {

  case class Span(price: Int, days: Int)

  class StockSpanner() {
    private val st = new mutable.Stack[Span]()

    def next(price: Int): Int = {
      var days = 1
      while (st.nonEmpty && (st.top.price <= price)) days += st.pop().days
      st.push(Span(price, days))
      days
    }
  }

}
