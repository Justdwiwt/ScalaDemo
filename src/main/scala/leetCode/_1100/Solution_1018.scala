package leetCode._1100

object Solution_1018 {
  def prefixesDivBy5(A: Array[Int]): Array[Boolean] = A.scanLeft(0) {
    case (n, i) => ((n << 1) | i) % 10
  }.tail.map(_ % 5 == 0)
}
