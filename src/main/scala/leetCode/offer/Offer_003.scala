package leetCode.offer

object Offer_003 {
  def countBits(n: Int): Array[Int] = {
    val res = Array.fill(n + 1)(0)
    (1 to n).foreach(i => res(i) = res(i >> 1) + (i & 1))
    res
  }
}
