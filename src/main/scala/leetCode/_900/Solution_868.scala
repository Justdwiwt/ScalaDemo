package leetCode._900

object Solution_868 {
  def binaryGap(n: Int): Int = {
    val binary = n.toBinaryString
    val ones = binary.indices.filter(binary(_) == '1')
    if (ones.size < 2) 0
    else ones.sliding(2).map(m => m(1) - m.head).max
  }
}
