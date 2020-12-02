package leetCode

object Solution_1576 {
  def modifyString(s: String): String = {
    if (s.length == 1 && s.head == '?') return "a"
    val diff = List('a', 'b', 'c')
    var res = ""
    var last = '-'

    @scala.annotation.tailrec
    def f(xs: List[Char], idx: Int): Char = xs match {
      case Nil => '-'
      case head :: _ if idx - 1 >= 0 && idx + 1 < s.length && head != s.charAt(idx - 1) && head != s.charAt(idx + 1) && head != last => head
      case head :: _ if idx - 1 < 0 && head != s.charAt(idx + 1) && head != last => head
      case head :: _ if idx + 1 >= s.length && head != s.charAt(idx - 1) && head != last => head
      case _ :: tail => f(tail, idx)
    }

    s.indices.foreach(i => {
      val c = s.charAt(i)
      val r = if (c == '?') f(diff, i) else c
      last = r
      res += r
    })
    res
  }
}
