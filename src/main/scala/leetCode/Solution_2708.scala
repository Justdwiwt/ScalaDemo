package leetCode

object Solution_2708 {
  def maxStrength(nums: Array[Int]): Long = nums.count(_ != 0) match {
    case 1 => nums.max
    case 0 => 0
    case _ => nums.filter(_ != 0)./:(1L)(_ * _) match {
      case x if x > 0 => x
      case x => x / nums.filter(_ < 0).max
    }
  }
}
