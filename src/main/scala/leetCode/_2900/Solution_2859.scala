package leetCode._2900

object Solution_2859 {
  def sumIndicesWithKSetBits(nums: List[Int], k: Int): Int = nums
    .zipWithIndex
    .collect { case (n, i) if i.toBinaryString.count(_ == '1') == k => n }
    .sum
}
