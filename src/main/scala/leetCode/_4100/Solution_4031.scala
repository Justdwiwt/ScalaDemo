package leetCode._4100

object Solution_4031 {
  def findDisappearedNumbers(nums: Array[Int], lower: Int, upper: Int): List[List[Int]] = (nums ++ Array(lower - 1, upper + 1))
    .sorted
    .sliding(2)
    .collect { case pair if pair(1) - pair(0) > 1 => List(pair(0) + 1, pair(1) - 1) }
    .flatMap {
      case List(l, r) if l <= upper && r >= lower => Some(List(l.max(lower), r.min(upper)))
      case _ => None
    }
    .toList
}
