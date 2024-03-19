package leetCode._2200

object Solution_2138 {
  def divideString(s: String, k: Int, fill: Char): Array[String] = s
    .padTo((s.length + k - 1) / k * k, fill)
    .grouped(k)
    .toArray
}
