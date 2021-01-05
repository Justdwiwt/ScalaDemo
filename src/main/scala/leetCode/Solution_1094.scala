package leetCode

object Solution_1094 {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    var cur = 0
    trips
      .flatMap(x => List((x(0), x(1)), (-x(0), x(2))))
      .sortBy(t => (t._2, t._1))
      .forall(t => {
        cur += t._1
        if (cur > capacity) false
        else true
      })
  }
}
