package leetCode

object Solution_849 {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var t = 1
    seats./:(seats.indexOf(1).max(seats.reverse.indexOf(1)))((res, cur) => {
      if (cur == 1) t = 1 else t += 1
      res.max(t / 2)
    })
  }
}
