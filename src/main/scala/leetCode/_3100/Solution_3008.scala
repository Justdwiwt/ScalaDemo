package leetCode._3100

object Solution_3008 {
  def beautifulIndices(s: String, a: String, b: String, k: Int): List[Int] = {
    val text = s.toCharArray
    val posA = kmp(text, a.toCharArray)
    val posB = kmp(text, b.toCharArray)

    def findIndices(posA: List[Int], posB: List[Int], k: Int): List[Int] = {
      @scala.annotation.tailrec
      def loop(posA: List[Int], posB: List[Int], ans: List[Int]): List[Int] = (posA, posB) match {
        case (Nil, _) => ans.reverse
        case (ha :: _, hb :: tb) if hb < ha - k => loop(posA, tb, ans)
        case (ha :: ta, hb :: _) if hb <= ha + k => loop(ta, posB, ha :: ans)
        case (_, _) => loop(posA.tail, posB, ans)
      }

      loop(posA, posB, Nil)
    }

    findIndices(posA, posB, k)
  }

  private def kmp(text: Array[Char], pattern: Array[Char]): List[Int] = {
    val n = pattern.length
    val pi = Array.fill(n)(0)
    var c = 0
    pattern.indices.drop(1).foreach(i => {
      while (c > 0 && pattern(c) != pattern(i)) c = pi(c - 1)
      if (pattern(c) == pattern(i)) c += 1
      pi(i) = c
    })

    @scala.annotation.tailrec
    def search(text: Array[Char], pattern: Array[Char], pi: Array[Int], c: Int, i: Int, res: List[Int]): List[Int] =
      if (i >= text.length) res.reverse
      else {
        val updatedC = {
          var tempC = c
          while (tempC > 0 && pattern(tempC) != text(i)) tempC = pi(tempC - 1)
          if (pattern(tempC) == text(i)) tempC + 1 else tempC
        }
        if (updatedC == n) search(text, pattern, pi, pi(updatedC - 1), i + 1, (i - n + 1) :: res)
        else search(text, pattern, pi, updatedC, i + 1, res)
      }

    search(text, pattern, pi, 0, 0, Nil)
  }
}
