package leetCode._900

object Solution_853 {
  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
    val sorted = position.indices.sortBy(i => -position(i))
    var res = 0
    var next = 0.0
    sorted.foreach(i => {
      val distance = target - position(i)
      val timeReached = distance / speed(i).toDouble
      if (timeReached <= next) {}
      else {
        res += 1
        next = timeReached
      }
    })
    res
  }
}
