package leetCode._4100

object Solution_4020 {
  def elevatorRequests(n: Int, requests: Array[Int]): Int = (0 +: requests)
    .sliding(2)
    .map(v => (v.last - v.head).abs)
    .sum
}
