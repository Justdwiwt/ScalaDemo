package leetCode._4100

object Solution_4023 {
  def elevatorRequests(n: Int, start: Int, requests: Array[Int]): Long = {
    val a = (requests ++ Array(start, -1, n)).sorted
    val m = a.length
    val idx = a.indexOf(start)
    val f = Array.fill(m, 2)(Long.MaxValue / 4)

    (1 to idx).foreach { i =>
      (m - 2 to idx by -1).foreach { j =>
        if (i == 1 && j == m - 2) {
          f(j)(0) = 0L
          f(j)(1) = 0L
        } else {
          val remain = m - 3 - j + i
          f(j)(1) = math.min(
            f(j)(0) + (a(j) - a(i - 1)).toLong * remain,
            f(j + 1)(1) + (a(j + 1) - a(j)).toLong * remain
          )
          f(j)(0) = math.min(
            f(j)(0) + (a(i) - a(i - 1)).toLong * remain,
            f(j + 1)(1) + (a(j + 1) - a(i)).toLong * remain
          )
        }
      }
    }

    f(idx)(0)
  }
}
