package leetCode

object Solution_1094 {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    val cnt = Array.fill(1001)(0)
    trips.foreach(i => {
      cnt(i(1)) += i(0)
      cnt(i(2)) -= i(0)
    })
    if (cnt(0) > capacity) return false
    (1 until cnt.length).foreach(i => {
      cnt(i) += cnt(i - 1)
      if (cnt(i) > capacity) return false
    })
    true
  }
}
