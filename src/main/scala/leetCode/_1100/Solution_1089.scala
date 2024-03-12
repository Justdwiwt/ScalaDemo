package leetCode._1100

object Solution_1089 {
  def duplicateZeros(arr: Array[Int]): Unit = {
    var cnt = arr.count(_ == 0)
    (arr.length - 1 until -1 by -1).foreach(i => {
      if (arr(i) == 0) {
        cnt -= 1
        if (i + cnt < arr.length) arr(i + cnt) = 0
        if (i + cnt + 1 < arr.length) arr(i + cnt + 1) = 0
      } else if (i + cnt < arr.length) arr(i + cnt) = arr(i)
    })
  }
}
