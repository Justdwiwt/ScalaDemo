package leetCode._3400

object Solution_3325 {
  def numberOfSubstrings(S: String, k: Int): Int = {
    val s = S.toCharArray
    val cnt = Array.fill(26)(0)

    @scala.annotation.tailrec
    def f(left: Int, right: Int, ans: Int): Int =
      if (right >= s.length) ans
      else {
        cnt(s(right) - 'a') += 1
        val newLeft = Iterator.from(left).takeWhile(_ => cnt(s(right) - 'a') >= k).foldLeft(left)((l, _) => {
          cnt(s(l) - 'a') -= 1
          l + 1
        })
        f(newLeft, right + 1, ans + newLeft)
      }

    f(0, 0, 0)
  }
}
