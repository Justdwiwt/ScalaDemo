package leetCode._3400

object Solution_3386 {
  def buttonWithLongestTime(events: Array[Array[Int]]): Int = {
    var res = events.head.head
    var max = events.head(1)
    events.indices.drop(1).foreach(i => {
      val gap = events(i)(1) - events(i - 1)(1)
      if (gap > max) {
        max = gap
        res = events(i).head
      } else if (gap == max) res = res.min(events(i).head)
    })
    res
  }
}
