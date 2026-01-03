package leetCode._3700

object Solution_3697 {
  def decimalRepresentation(n: Int): Array[Int] = n
    .toString
    .reverse
    .zipWithIndex
    .collect { case (c, i) if c != '0' => (c - '0') * math.pow(10, i).toInt }
    .reverse
    .toArray
}
