package leetCode

object Solution_2138 {
  def divideString(s: String, k: Int, fill: Char): Array[String] = {
    val r = s.length % k
    val padded = if (r == 0) s else s.padTo(s.length + k - r, fill)
    padded.grouped(k).toArray
  }
}
