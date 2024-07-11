package leetCode._3300

object Solution_3215 {
  def tripletCount(a: Array[Int], b: Array[Int], c: Array[Int]): Long = {
    val (evenA, oddA) = countEvenOdd(a)
    val (evenB, oddB) = countEvenOdd(b)
    val (evenC, oddC) = countEvenOdd(c)

    evenA * evenB * evenC + evenA * oddB * oddC + oddA * evenB * oddC + oddA * oddB * evenC
  }

  private def countEvenOdd(arr: Array[Int]): (Long, Long) = arr
    .map(num => if (Integer.bitCount(num) % 2 == 0) (1L, 0L)
    else (0L, 1L)).reduce[(Long, Long)] { case ((even1, odd1), (even2, odd2)) => (even1 + even2, odd1 + odd2) }
}
