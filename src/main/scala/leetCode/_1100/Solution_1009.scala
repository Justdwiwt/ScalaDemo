package leetCode._1100

object Solution_1009 {
  def bitwiseComplement(N: Int): Int =
    ~N & 1.max(Integer.highestOneBit(N) - 1)
}
