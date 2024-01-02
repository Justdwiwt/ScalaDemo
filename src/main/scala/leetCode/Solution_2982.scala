package leetCode

object Solution_2982 {
  private[this] val lens = Array.fill(26 * 3)(0)

  def maximumLength(s: String): Int = {
    val n = s.length
    var start = 0
    var last = s(0)
    (1 until n).foreach(i => {
      val c = s(i)
      if (c != last) {
        var len = i - start
        val b = (last - 'a') * 3
        if (len > lens(b)) {
          val t = lens(b)
          lens(b) = len
          len = t
        }
        if (len > lens(b + 1)) {
          val t = lens(b + 1)
          lens(b + 1) = len
          len = t
        }
        if (len > lens(b + 2))
          lens(b + 2) = len
        start = i
        last = c
      }
    })

    var len = n - start
    val b = (last - 'a') * 3
    if (len > lens(b)) {
      val t = lens(b)
      lens(b) = len
      len = t
    }
    if (len > lens(b + 1)) {
      val t = lens(b + 1)
      lens(b + 1) = len
      len = t
    }
    if (len > lens(b + 2))
      lens(b + 2) = len

    var maxlen = 0
    (0 until 78 by 3).foreach(j => if (lens(j) != 0) {
      val len = if (lens(j + 1) == lens(j))
        lens(j) - (if (lens(j + 2) < lens(j)) 1 else 0)
      else if (lens(j + 1) > lens(j) - 2) lens(j + 1) else lens(j) - 2
      if (maxlen < len) maxlen = len
      lens(j) = 0
      lens(j + 1) = 0
      lens(j + 2) = 0
    })
    if (maxlen > 0) maxlen else -1
  }
}
