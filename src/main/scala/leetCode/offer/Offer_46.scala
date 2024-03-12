package leetCode.offer

object Offer_46 {
  def translateNum(num: Int): Int = {
    if (num <= 9) return 1
    val t = num % 100
    if (t <= 9 || t >= 26) translateNum(num / 10)
    else translateNum(num / 10) + translateNum(num / 100)
  }
}
