package leetCode

object Solution_779 {
  def kthGrammar(N: Int, K: Int): Int = (K - 1).toBinaryString.count(_ == '1') % 2
}
