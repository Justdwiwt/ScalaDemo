package leetCode._3200

object Solution_3168 {
  def minimumChairs(s: String): Int =
    s.foldLeft((0, 0)) { case ((res, cnt), c) =>
      if (c == 'E') (res.max(cnt + 1), cnt + 1)
      else (res, cnt - 1)
    }._1
}
