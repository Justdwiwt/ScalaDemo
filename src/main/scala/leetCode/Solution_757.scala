package leetCode

object Solution_757 {
  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
    var res = 0
    var p1 = -1
    var p2 = -1
    val arr = func(intervals)
    arr.foreach(x => {
      if (x(0) > p1)
        if (x(0) > p2) {
          res += 2
          p2 = x(1)
          p1 = p2 - 1
        }
        else {
          res += 1
          p1 = p2
          p2 = x(1)
        }
    })
    res
  }

  def func(interval: Array[Array[Int]]): Array[Array[Int]] = interval.sortBy(x => (x(1), -x(0)))

}
