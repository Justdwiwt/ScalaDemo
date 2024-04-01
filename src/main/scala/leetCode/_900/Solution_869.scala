package leetCode._900

object Solution_869 {
  def reorderedPowerOf2(N: Int): Boolean =
    (0 until 30).exists(pow => (1 << pow).toString.sorted == N.toString.sorted)
}
