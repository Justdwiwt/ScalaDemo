package leetCode._300

object Solution_260 {
  def singleNumber(nums: Array[Int]): Array[Int] =
    nums./:(Set.empty[Int]) { case (acc, v) => if (acc.contains(v)) acc - v else acc + v }.toArray
}
