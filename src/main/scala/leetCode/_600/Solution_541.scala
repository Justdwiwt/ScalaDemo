package leetCode._600

object Solution_541 {
  def reverseStr(s: String, k: Int): String =
    s.sliding(k, k).zipWithIndex.map({ case (arr, x) => if (x % 2 == 0) arr.reverse else arr }).reduce(_ + _)
}
