package leetCode._2500

object Solution_2491 {
  def dividePlayers(skill: Array[Int]): Long = {
    val (weakest, strongest) = skill.sorted.splitAt(skill.length / 2)
    val teams = weakest.zip(strongest.reverse)
    if (teams.map { case (p1, p2) => p1.toDouble + p2 }.distinct.length != 1) -1
    else teams./:(0L) { case (result, (p1, p2)) => result + p1 * p2 }
  }
}
