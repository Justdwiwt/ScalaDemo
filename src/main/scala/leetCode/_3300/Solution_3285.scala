package leetCode._3300

object Solution_3285 {
  def stableMountains(height: Array[Int], threshold: Int): List[Int] = height
    .init
    .zipWithIndex
    .collect { case (h, i) if h > threshold => i + 1 }
    .toList
}
