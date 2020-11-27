package leetCode

object Solution_1588 {
  def sumOddLengthSubarrays(arr: Array[Int]): Int = {
    arr.indices.map(i => ((i + 1) * (arr.length - i) + 1) / 2 * arr(i)).sum
  }
}
