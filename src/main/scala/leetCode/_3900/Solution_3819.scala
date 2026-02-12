package leetCode._3900

object Solution_3819 {
  def rotateElements(nums: Array[Int], k: Int): Array[Int] = {
    val values = nums.filter(_ >= 0)
    if (k == 0 || values.length == 0) nums
    else {
      var rotateLength = (k + values.length - 1) % values.length
      nums.map(curr =>
        if (curr >= 0) {
          rotateLength = (rotateLength + 1) % values.length
          values(rotateLength)
        } else curr
      )
    }
  }
}
