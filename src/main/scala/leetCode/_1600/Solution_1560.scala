package leetCode._1600

object Solution_1560 {
  def mostVisited(n: Int, rounds: Array[Int]): List[Int] = {
    (rounds.head to (if (rounds.head <= rounds.last) rounds.last else rounds.last + n)).map(i => 1 + ((i - 1) % n)).toList.sorted
  }
}
