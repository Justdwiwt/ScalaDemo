package leetCode._4100

object Solution_4038 {
  def countSpecialIntegers(nums: Array[Int]): Int = {
    val (seen, bad, _) = nums.foldLeft(
      (Set.empty[Int], Set.empty[Int], -1)
    ) {
      case ((seen, bad, previous), x) =>
        if (x == previous) (seen, bad, previous)
        else if (seen.contains(x)) (seen, bad + x, x)
        else (seen + x, bad, x)
    }

    (seen -- bad).size
  }
}
