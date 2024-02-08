package leetCode

object Code_16_14 {
  def bestLine(points: Array[Array[Int]]): Array[Int] = {
    var mx = 0
    var res = Array.empty[Int]
    points.indices.foreach(i => {
      (i + 1 until points.length).foreach(j => {
        val h1 = points(j)(1) - points(i)(1)
        val w1 = points(j).head - points(i).head
        var tmp = 1
        (j + 1 until points.length).foreach(k => {
          val h2 = points(k)(1) - points(i)(1)
          val w2 = points(k).head - points(i).head
          if ((h1 * w2).toLong == (h2 * w1).toLong) tmp += 1
        })
        if (tmp > mx) {
          mx = tmp
          res = Array(i, j)
        }
      })
    })
    res
  }
}
