package leetCode._2200

object Solution_2154 {
  def findFinalValue(nums: Array[Int], original: Int): Int = Iterator
    .iterate(original)(_ * 2)
    .dropWhile(nums.toSet.contains)
    .next()
}
