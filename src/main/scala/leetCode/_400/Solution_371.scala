package leetCode._400

object Solution_371 {
  @scala.annotation.tailrec
  def getSum(a: Int, b: Int): Int = b match {
    case 0 => a
    case _ => getSum(a ^ b, (a & b) << 1)
  }
}
