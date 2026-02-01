package leetCode._3800

object Solution_3794 {
  def reversePrefix(s: String, k: Int): String =
    s.take(k).reverse + s.drop(k)
}
