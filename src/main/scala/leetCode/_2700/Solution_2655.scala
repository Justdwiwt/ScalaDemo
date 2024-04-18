package leetCode._2700

object Solution_2655 {
  def findMaximalUncoveredRanges(n: Int, ranges: Array[Array[Int]]): Array[Array[Int]] = {
    val sorted = ranges.sortBy(_.head)
    var res = List.empty[Array[Int]]
    var c = 0

    sorted.foreach(arr => {
      val left = arr.head
      val r = arr(1)
      if (c < left) res :+= Array(c, left - 1)
      val t = r + 1
      if (t > c) c = t
    })

    if (c < n) res :+= Array(c, n - 1)

    res.toArray
  }
}
