package leetCode

object Solution_2584 {
  def findValidSplit(nums: Array[Int]): Int = {
    var t = 0
    nums.indices.dropRight(1).foreach(i => {
      (t + 1 until nums.length).foreach(j => if (gcd(nums(i), nums(j)) != 1) t = j)
      if (t <= i) return i
    })
    -1
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
