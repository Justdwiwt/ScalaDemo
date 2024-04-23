package leetCode._2200

object Solution_2158 {
  def amountPainted(paint: Array[Array[Int]]): Array[Int] = {
    val max = paint.map(interval => interval(1)).max
    val paints = Array.fill(max + 1)(1)
    val log = Array.fill(paint.length)(0)
    paint.indices.foreach(i => {
      val days = countAndPaint(paints, paint(i).head, paint(i)(1))
      log(i) = days
    })
    log
  }

  private def countAndPaint(paints: Array[Int], start: Int, end: Int): Int = {
    var cnt = 0
    (start until end).foreach(i => if (paints(i) == 1) {
      cnt += 1
      paints(i) = 0
    })
    cnt
  }
}
