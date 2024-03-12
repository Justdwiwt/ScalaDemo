package leetCode._1900

object Solution_1869 {
  def checkZeroOnes(s: String): Boolean =
    f('1', s) > f('0', s)

  def f(c: Character, s: String): Int = {
    var (cnt, mx) = (0, 0)
    val ch = s.toCharArray
    ch.indices.foreach(i => if (ch(i) == c) {
      cnt += 1
      if (i < ch.length - 1 && ch(i + 1) != c) {
        mx = mx.max(cnt)
        cnt = 0
      } else if (i == ch.length - 1) {
        mx = mx.max(cnt)
      }
    })
    mx
  }
}
