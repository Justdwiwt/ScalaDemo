package leetCode._2400

object Solution_2350 {
  def shortestSequence(rolls: Array[Int], k: Int): Int = rolls./:(1, Set.empty[Int]) {
    case ((shortest, seen), n) => if ((seen + n).size == k) (shortest + 1, Set.empty) else (shortest, seen + n)
  }._1
}
