package leetCode._400

object Solution_370 {
  def getModifiedArray(length: Int, updates: Array[Array[Int]]): Array[Int] = {
    val res = Array.fill(length)(0)

    updates.foreach { case Array(start, end, value) =>
      res(start) += value
      if (end + 1 < length) res(end + 1) -= value
    }

    res.scanLeft(0)(_ + _).drop(1)
  }
}
