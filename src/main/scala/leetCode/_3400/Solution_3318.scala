package leetCode._3400

object Solution_3318 {
  def findXSum(nums: Array[Int], k: Int, x: Int): Array[Int] = (0 to nums.length - k)
    .map { start => val counts = nums.slice(start, start + k).groupBy(identity).mapValues(_.length); (start, counts) }
    .map { case (start, counts) => val sorted = counts.toArray.sortBy { case (v, c) => -c * 1000 - v }; (start, counts, sorted) }
    .map { case (_, _, sorted) => sorted.take(x).map { case (v, c) => v * c }.sum }
    .toArray
}
