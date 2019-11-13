package leetCode

object Solution_670 {
  def maximumSwap(num: Int): Int = {
    val arr = num.toString.toCharArray
    var mx = arr.length - 1
    var pos1 = -1
    var pos2 = -1
    (arr.length - 2 to 0 by -1).foreach(i => {
      if (arr(i) < arr(mx)) {
        pos1 = i
        pos2 = mx
      } else if (arr(i) > arr(mx)) mx = i
    })
    if (pos1 != -1) {
      val t = arr(pos1)
      arr(pos1) = arr(pos2)
      arr(pos2) = t
    }
    val t = new StringBuilder
    arr.foreach(i => t.append(i))
    t.toInt
  }
}
