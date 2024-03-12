package leetCode._2200

object Solution_2165 {
  def smallestNumber(num: Long): Long = {
    if (num == 0) 0
    else if (num < 0) -(-num).toString.sorted.reverse.toLong
    else {
      val digs = num.toString
      val (zeros, nonZeros) = digs.partition(_ == '0')
      val nz1 = nonZeros.sorted
      ((nz1.head +: zeros) ++ nz1.tail).toLong
    }
  }
}
