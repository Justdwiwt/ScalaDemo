package leetCode._500

object Solution_443 {
  private def f(chars: Array[Char], cmp: Int, count: Int, out: Int): Int = {
    chars(out - 1) = chars(cmp)
    if (count == 1) 0
    else {
      val len = count.toString
      len.indices.foreach(i => chars(out + i) = len(i))
      len.length
    }
  }

  @scala.annotation.tailrec
  def compress(chars: Array[Char], cmp: Int = 0, in: Int = 1, count: Int = 1, out: Int = 1): Int =
    if (in == chars.length) out + f(chars, cmp, count, out)
    else if (chars(cmp) != chars(in)) compress(chars, in, in + 1, 1, out + 1 + f(chars, cmp, count, out))
    else compress(chars, in, in + 1, count + 1, out)
}
