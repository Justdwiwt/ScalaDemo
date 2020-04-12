package leetCode

object Offer_65 {
  @scala.annotation.tailrec
  def add(a: Int, b: Int): Int = {
    if (b == 0) return a
    if (a == 0) return b
    val p = a ^ b
    val q = (a & b) << 1
    add(p, q)
  }
}
