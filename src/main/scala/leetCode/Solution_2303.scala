package leetCode

object Solution_2303 {
  def calculateTax(brackets: Array[Array[Int]], income: Int): Double = {
    var res = 0.0
    res += income.min(brackets.head.head) * brackets.head(1) / 100.0
    var in = income - brackets.head.head
    if (in <= 0) return res
    var i = 1
    while (i < brackets.length && in > 0) {
      res += in.min(brackets(i).head - brackets(i - 1).head) * brackets(i)(1) / 100.0
      in -= (brackets(i).head - brackets(i - 1).head)
      i += 1
    }
    res
  }
}
