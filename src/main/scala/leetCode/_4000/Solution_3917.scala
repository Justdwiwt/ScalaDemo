package leetCode._4000

object Solution_3917 {
  def countOppositeParity(nums: Array[Int]): Array[Int] =
    nums.foldRight((0, 0, List.empty[Int])) {
      case (v, (odds, evens, list)) =>
        if (v % 2 == 0) (odds, evens + 1, odds :: list)
        else (odds + 1, evens, evens :: list)
    }._3.toArray
}
