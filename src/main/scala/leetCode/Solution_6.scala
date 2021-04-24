package leetCode

object Solution_6 {
  def convert(s: String, numRows: Int): String = zigStream(numRows - 1).zip(s).sortBy(_._1).map(_._2).mkString

  def zigStream(zagLength: Int): Stream[Int] = Stream.continually((0 to zagLength) ++ (zagLength - 1 to 1 by -1)).flatten
}
