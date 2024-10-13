package leetCode._3400

object Solution_3314 {
  def minBitwiseArray(nums: List[Int]): Array[Int] = {
    nums.map {
      case 2 => -1
      case x =>
        val t = ~x
        x ^ ((t & -t) >> 1)
    }
  }.toArray
}
