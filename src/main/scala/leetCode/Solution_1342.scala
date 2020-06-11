package leetCode

object Solution_1342 {
  @scala.annotation.tailrec
  def numberOfSteps(num: Int, acc: Int = 0): Int = num match {
    case 0 => 0.max(acc - 1)
    case _ => numberOfSteps(num >> 1, acc + 1 + (num & 1))
  }
}
