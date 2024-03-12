package leetCode.offer

object Offer_62 {
  def lastRemaining(n: Int, m: Int): Int = {
    var res = 0
    (2 to n).foreach(i => res = (res + m) % i)
    res
  }
}
