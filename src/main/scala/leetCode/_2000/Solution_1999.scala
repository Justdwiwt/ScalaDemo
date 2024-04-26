package leetCode._2000

object Solution_1999 {
  def findInteger(k: Int, digit1: Int, digit2: Int): Int = {
    val pq = new java.util.PriorityQueue[Int]()
    if (digit1 > 0) pq.add(digit1)
    if (digit2 > 0) pq.add(digit2)
    while (!pq.isEmpty) {
      val num: Int = pq.poll()
      if (num > k && num % k == 0) return num
      if (num <= (Int.MaxValue - digit1) / 10) pq.add(num * 10 + digit1)
      if (num <= (Int.MaxValue - digit2) / 10) pq.add(num * 10 + digit2)
    }
    -1
  }
}
