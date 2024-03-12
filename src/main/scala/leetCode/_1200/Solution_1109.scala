package leetCode._1200

object Solution_1109 {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    bookings.indices.foreach(i => (bookings(i)(0) to bookings(i)(1)).foreach(j => res(j - 1) += bookings(i)(2)))
    res
  }
}
