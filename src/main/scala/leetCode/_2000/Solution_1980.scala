package leetCode._2000

object Solution_1980 {
  def findDifferentBinaryString(nums: Array[String]): String =
    nums.indices.foldLeft("") { case (res, i) => res :+ (if (nums(i)(i) == '0') '1' else '0') }
}
