package leetCode._3800

object Solution_3754 {
  def sumAndMultiply(n: Int): Long = {
    val ns = n.toString.filter(_ != '0')
    if (ns.isEmpty) 0L
    else ns.toInt * ns.map(_.asDigit).sum.toLong
  }
}
