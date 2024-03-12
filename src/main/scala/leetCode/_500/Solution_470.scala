package leetCode._500

object Solution_470 {
  @scala.annotation.tailrec
  def rand10(): Int = {
    val idx = rand7() + (rand7() - 1) * 7
    if (idx > 40) rand10()
    else 1 + (idx - 1) % 10
  }

  def rand7(): Int = {
    ???
  }
}
