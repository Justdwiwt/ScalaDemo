package leetCode._2000

object Solution_1936 {
  def addRungs(rungs: Array[Int], dist: Int): Int = {
    var cnt = 0
    var pre = 0
    rungs.foreach(cur => {
      if (cur - pre > dist) {
        val diff = cur - pre
        cnt += (if (diff % dist != 0) diff / dist else diff / dist - 1)
      } else {
      }
      pre = cur
    })
    cnt
  }
}
