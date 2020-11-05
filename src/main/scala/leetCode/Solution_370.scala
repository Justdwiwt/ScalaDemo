package leetCode

object Solution_370 {
  def getModifiedArray(length: Int, updates: Array[Array[Int]]): Array[Int] = {
    val res = Array.fill(length)(0)
    updates.foreach(i => {
      res(i(1)) += i(2)
      if (i.head > 0) res(i.head - 1) -= i(2)
    })
    (length - 2 to 0 by -1).foreach(i => res(i) += res(i + 1))
    res
  }
}
