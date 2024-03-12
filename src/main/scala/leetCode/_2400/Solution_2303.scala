package leetCode._2400

object Solution_2303 {
  def calculateTax(brackets: Array[Array[Int]], income: Int): Double = brackets./:((0.0, 0.0))((acc, cur) => {
    if (income > cur.head) (acc._1 + (cur.head - acc._2) * cur(1) / 100.0, cur.head)
    else return acc._1 + ((income - acc._2) * cur(1) / 100.0)
  })._1
}
