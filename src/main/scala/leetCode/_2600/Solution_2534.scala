package leetCode._2600

object Solution_2534 {
  def timeTaken(arrival: Array[Int], state: Array[Int]): Array[Int] = {
    val n = arrival.length
    val res = Array.fill(n)(0)
    var t = 0
    var door = 1
    val cur = Array(0, 0)
    while (cur.min < n) {
      if (arrival(cur.min) > t) {
        door = 1
        t = arrival(cur.min)
      }
      while (cur(door) < n && arrival(cur(door)) <= t) {
        if (state(cur(door)) == door) {
          res(cur(door)) = t
          t += 1
        }
        cur(door) += 1
      }
      door ^= 1
    }
    res
  }
}
