package leetCode._1800

object Solution_1705 {
  def eatenApples(apples: Array[Int], days: Array[Int]): Int = {
    var day = 0
    days.indices.foreach(i => day = day.max(i + days(i)))
    val arr = Array.fill(day)(0)
    var curMx = day
    var res = 0
    (0 until day).foreach(i => {
      if (i < apples.length && apples(i) != 0) {
        arr(i + days(i) - 1) += apples(i)
        curMx = curMx.min(days(i) + i - 1)
      }
      var idx = i.max(curMx)
      while (idx < day && arr(idx) == 0) idx += 1
      if (idx != day) {
        arr(idx) -= 1
        res += 1
      }
    })
    res
  }
}
