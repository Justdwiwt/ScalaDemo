package leetCode

object Solution_657 {
  def judgeCircle(moves: String): Boolean = moves.count(_.equals('U')) == moves.count(_.equals('D')) && moves.count(_.equals('L')) == moves.count(_.equals('R'))
}
