package leetCode

object Solution_2947 {
  def beautifulSubstrings(s: String, k: Int): Int = {
    val res = Array.fill(s.length)(0)
    if ("aeiou".contains(s.head)) res(0) = 1
    s.indices.drop(1).foreach(i => if ("aeiou".contains(s(i))) res(i) = res(i - 1) + 1 else res(i) = res(i - 1))

    @scala.annotation.tailrec
    def f(i: Int, j: Int, r: Int): Int = {
      if (j == s.length) return r
      val vowel = if ("aeiou".contains(s(i))) res(j) - res(i) + 1 else res(j) - res(i)
      val consonent = (j - i + 1) - vowel
      if (vowel == consonent && (vowel * consonent) % k == 0) f(i, j + 1, r + 1) else f(i, j + 1, r)
    }

    s.indices.dropRight(1).map(i => f(i, i + 1, 0)).sum
  }
}
