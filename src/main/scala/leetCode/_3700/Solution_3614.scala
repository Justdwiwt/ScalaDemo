package leetCode._3700

object Solution_3614 {
  def processStr(s: String, k0: Long): Char = {
    val sz = s.foldLeft(0L) {
      case (sz, '*') => math.max(sz - 1, 0)
      case (sz, '#') => sz * 2
      case (sz, '%') => sz
      case (sz, _) => sz + 1
    }

    if (k0 >= sz) return '.'

    @scala.annotation.tailrec
    def backtrack(i: Int, sz: Long, k: Long): Char =
      if (i < 0) '.'
      else s(i) match {
        case '*' => backtrack(i - 1, sz + 1, k)
        case '#' =>
          val half = sz / 2
          if (k >= half) backtrack(i - 1, half, k - half)
          else backtrack(i - 1, half, k)
        case '%' => backtrack(i - 1, sz, sz - 1 - k)
        case c =>
          val sz1 = sz - 1
          if (k == sz1) c else backtrack(i - 1, sz1, k)
      }

    backtrack(s.length - 1, sz, k0)
  }
}
