package leetCode._400

object Solution_371 {
  @scala.annotation.tailrec
  def getSum(a: Int, b: Int): Int = {
    if (b == 0) return a
    val c1: Int = a ^ b
    val c2: Int = (a & b) << 1
    getSum(c1, c2)
  }
}
