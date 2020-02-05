package leetCode

object Solution_779 {
  def kthGrammar(N: Int, K: Int): Int = Integer.bitCount(K - 1) % 2
}
