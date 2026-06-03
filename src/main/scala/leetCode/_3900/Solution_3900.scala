package leetCode._3900

object Solution_3900 {
  def longestBalanced(s: String): Int = {
    val total0 = s.count(_ == '0')
    val total1 = s.length - total0

    val pos = collection.mutable.Map(0 -> Vector(-1))

    s.zipWithIndex.foldLeft((0, 0)) {
        case ((ans, pre), (ch, i)) =>
          val cur = pre + (if (ch == '1') 1 else -1)

          pos.get(cur).fold(pos.update(cur, Vector(i)))(p => if (p.size == 1) pos.update(cur, p :+ i))

          def upd(d: Int, total: Int, now: Int): Int = pos.get(cur + d).fold(now)(p => {
            if ((i - p.head - 2) / 2 < total) now.max(i - p.head)
            else if (p.size > 1) now.max(i - p(1))
            else now
          })

          val res = List(ans.max(i - pos(cur).head), upd(-2, total0, ans), upd(2, total1, ans)).max

          (res, cur)
      }
      ._1
  }
}
