package leetCode._700

object Solution_696 {
  def countBinarySubstrings(s: String): Int = {
    val cnt = s.tail./:(s.head, 1 :: Nil) { case ((h, l), c) => if (h == c) (c, l.head + 1 :: l.tail) else (c, 1 :: l) }._2
    cnt.tail./:(cnt.head, 0) { case ((pre, acc), cur) => (cur, acc + cur.min(pre)) }._2
  }
}
