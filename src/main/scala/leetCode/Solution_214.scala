package leetCode

object Solution_214 {
  def shortestPalindrome(s: String): String = {
    val idx = s.indices.reverse.find(idx => {
      (0 until idx).view.zip(idx to 0 by -1).forall({ case (l, r) => s(l) == s(r) })
    }).getOrElse(0)
    s.slice(idx + 1, s.length).reverse + s
  }
}
