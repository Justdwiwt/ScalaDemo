package leetCode

object Solution_376 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    var up = 1
    var down = 1
    (1 until nums.length).foreach(i => {
      if (nums(i) > nums(i - 1)) up = down + 1
      else if (nums(i) < nums(i - 1)) down = up - 1
    })
    if (nums.isEmpty) 0 else up.max(down)
  }
}
