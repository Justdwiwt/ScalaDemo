package leetCode._2800

object Solution_2751 {
  private case class Robot(pos: Int, health: Int, isRight: Boolean, idx: Int)

  def survivedRobotsHealths(positions: Array[Int], healths: Array[Int], directions: String): List[Int] = {
    val raw = positions.zip(healths).zip(directions).zipWithIndex
    val robots = raw.map { case (((pos, h), dir), idx) => Robot(pos, h, dir == 'R', idx) }
    f(robots.sortBy(_.pos).toList, Nil, Nil).sortBy(_.idx).map(_.health)
  }

  @scala.annotation.tailrec
  private def f(robots: List[Robot], goRight: List[Robot], goLeft: List[Robot]): List[Robot] = robots match {
    case Nil => goLeft ++ goRight
    case robot :: tail =>
      if (robot.isRight) f(tail, robot :: goRight, goLeft)
      else {
        val (nRight, nLeft) = g(goRight, robot)
        f(tail, nRight, nLeft.toList ::: goLeft)
      }
  }

  @scala.annotation.tailrec
  private def g(goRight: List[Robot], robot: Robot): (List[Robot], Option[Robot]) = goRight match {
    case Nil => (Nil, Some(robot))
    case other :: tail =>
      if (other.health < robot.health) g(tail, robot.copy(health = robot.health - 1))
      else if (other.health == robot.health) (tail, None)
      else (other.copy(health = other.health - 1) :: tail, None)
  }
}
