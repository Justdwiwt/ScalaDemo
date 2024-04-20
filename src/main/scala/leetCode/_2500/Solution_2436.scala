package leetCode._2500

object Solution_2436 {
  def minimumSplits(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    @scala.annotation.tailrec
    def f(nums: List[Int], cnt: Int, g: Int): Int = nums match {
      case Nil => cnt
      case head :: tail =>
        val newGcd = gcd(g, head)
        if (newGcd == 1) f(tail, cnt + 1, head)
        else f(tail, cnt, newGcd)
    }

    f(nums.tail.toList, 1, nums.head)
  }
}
