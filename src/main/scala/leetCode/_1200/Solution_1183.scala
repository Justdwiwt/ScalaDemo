package leetCode._1200

object Solution_1183 {
  def maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int = (0 until sideLength)
    .flatMap(i => (0 until sideLength).map(j => ((width - 1 - i) / sideLength + 1) * ((height - 1 - j) / sideLength + 1)))
    .sorted
    .reverse
    .take(maxOnes)
    .sum
}
