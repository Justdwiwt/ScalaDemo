package leetCode.offer

object XH_1_2 {
  def find_left_repeat_numII(nums: Array[Int]): Array[Int] = {
    val mx = nums.max
    val res = Array.fill(mx + 1)(-2)
    nums.indices.foreach(i => {
      if (res(nums(i)) == -2) {
        res(nums(i)) = i
        nums(i) = -1
      } else {
        val t = nums(i)
        nums(i) = res(nums(i))
        res(t) = i
      }
    })
    nums
  }
}
