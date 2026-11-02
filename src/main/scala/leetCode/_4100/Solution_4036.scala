package leetCode._4100

object Solution_4036 {
  def largestString(nums: Array[Int]): Array[String] = nums.map { x =>
    ("z" * (x >>> 25)) + (0 to 24)
      .reverse
      .filter(i => (x >>> i & 1) == 1)
      .map(i => ('a' + i).toChar)
      .mkString
  }
}
