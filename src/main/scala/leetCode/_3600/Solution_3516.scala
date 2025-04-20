package leetCode._3600

object Solution_3516 {
  def findClosest(person1: Int, person2: Int, goal: Int): Int =
    (goal - person1).abs - (goal - person2).abs match {
      case 0 => 0
      case n if n < 0 => 1
      case _ => 2
    }
}
