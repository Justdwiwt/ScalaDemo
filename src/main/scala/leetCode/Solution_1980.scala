package leetCode

object Solution_1980 {
  def findDifferentBinaryString(nums: Array[String]): String = {
    val res = Array.fill(nums.length)('0')
    res.indices.foreach(i => if (nums(i)(i) == '0') res(i) = '1')
    res.mkString
  }
}
