package leetCode._600

object Solution_598 {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int =
    ops.foldLeft(Array(m, n))((op1, op2) => Array(op1.head.min(op2.head), op1(1).min(op2(1)))).product
}
