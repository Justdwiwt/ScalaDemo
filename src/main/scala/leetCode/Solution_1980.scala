package leetCode

object Solution_1980 {
  def findDifferentBinaryString(nums: Array[String]): String = {
    val st = nums.map(Integer.parseInt(_, 2)).toSet
    (0 until (1 << nums.length)).foreach(i => if (!st.contains(i)) return "0" * (nums.length - i.toBinaryString.length) + i.toBinaryString)
    ""
  }
}
