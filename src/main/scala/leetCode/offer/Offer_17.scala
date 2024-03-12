package leetCode.offer

object Offer_17 {
  def printNumbers(n: Int): Array[Int] = {
    val res = Array.fill(math.pow(10, n).toInt - 1)(0)
    (1 until math.pow(10, n).toInt).foreach(i => res(i - 1) = i)
    res
  }
}
