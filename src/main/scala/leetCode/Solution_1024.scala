package leetCode

object Solution_1024 {
  def videoStitching(clips: Array[Array[Int]], T: Int): Int = {
    var res = 0
    var e = 0
    while (e < T) {
      val t = e
      e = func(e, clips)
      if (t == e) return -1
      res += 1
    }
    res
  }

  def func(s: Int, clips: Array[Array[Int]]): Int = {
    var mx = 0
    clips.foreach(v => if (v(0) <= s && v(1) >= s) mx = mx.max(v(1)))
    mx
  }
}
