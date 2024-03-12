package leetCode._2100

object Solution_2037 {
  def minMovesToSeat(seats: Array[Int], students: Array[Int]): Int = seats
    .sorted
    .zip(students.sorted)
    .map({ case (p1, p2) => (p1 - p2).abs })
    .sum
}
