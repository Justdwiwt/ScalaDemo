package leetCode

object Solution_679 {
  def judgePoint24(nums: Array[Int]): Boolean = {
    backTrack(nums, 0)
  }

  def backTrack(nums: Array[Int], idx: Int): Boolean = idx match {
    case 4 => judge(nums(0), nums(1), nums(2), nums(3))
    case _ =>
      (idx until 4).foreach(i => {
        swap(nums, idx, i)
        if (backTrack(nums, idx + 1)) return true
        swap(nums, idx, i)
      })
      false
  }

  def swap(nums: Array[Int], a: Int, b: Int): Unit = {
    val t = nums(a)
    nums(a) = nums(b)
    nums(b) = t
  }

  def judge(a: Double, b: Double, c: Double, d: Double): Boolean = {
    judge(a + b, c, d) ||
      judge(a - b, c, d) ||
      judge(a * b, c, d) ||
      judge(a / b, c, d)
  }

  def judge(a: Double, b: Double, c: Double): Boolean = {
    judge(a + b, c) ||
      judge(a - b, c) ||
      judge(a * b, c) ||
      judge(a / b, c) ||
      judge(b - a, c) ||
      judge(b / a, c) ||
      judge(a, b - c) ||
      judge(a, b + c) ||
      judge(a, b * c) ||
      judge(a, b / c)
  }

  def judge(a: Double, b: Double): Boolean = {
    (a + b - 24).abs < 0.001 ||
      (a - b - 24).abs < 0.001 ||
      (a * b - 24).abs < 0.001 ||
      (a / b - 24).abs < 0.001 ||
      (b - a - 24).abs < 0.001 ||
      (b / a - 24).abs < 0.001
  }
}
