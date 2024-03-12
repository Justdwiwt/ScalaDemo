package leetCode.offer

object Offer_56_1 {
  def singleNumbers(nums: Array[Int]): Array[Int] = {
    var xor = nums(0)
    (1 until nums.length).foreach(i => xor ^= nums(i))
    val p = xor & (-xor)
    var res1 = 0
    var res2 = 0
    nums.indices.foreach(i => if ((nums(i) & p) == p) res1 ^= nums(i) else res2 ^= nums(i))
    Array(res1 ^ 0, res2 ^ 0)
  }
}
