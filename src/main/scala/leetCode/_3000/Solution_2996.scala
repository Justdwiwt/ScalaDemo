package leetCode._3000

object Solution_2996 {
  def missingInteger(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(nums: List[Int], cur: Int): Int = nums match {
      case Nil => cur
      case head :: Nil => cur + head
      case head :: next :: tail if next == head + 1 => f(next :: tail, cur + head)
      case head :: _ => cur + head
    }

    val prefixSum = f(nums.toList, 0)

    Stream.from(prefixSum).find(!nums.contains(_)).getOrElse(prefixSum)
  }
}
