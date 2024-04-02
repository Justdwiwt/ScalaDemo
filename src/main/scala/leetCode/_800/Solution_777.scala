package leetCode._800

object Solution_777 {
  private def f(s: String): List[(Char, Int)] =
    s.toList.zipWithIndex.collect { case (c, i) if c == 'R' || c == 'L' => (c, i) }

  def canTransform(start: String, end: String): Boolean = (f(start), f(end)) match {
    case (startLR, endLR) if startLR.size != endLR.size => false
    case (startLR, endLR) => startLR.foldLeft((endLR, true)) {
      case ((_, res), _) if !res => (Nil, res)
      case ((('R', endPosCur) :: endPosRest, res), ('R', charPos)) if endPosCur >= charPos => (endPosRest, res)
      case ((('L', endPosCur) :: endPosRest, res), ('L', charPos)) if endPosCur <= charPos => (endPosRest, res)
      case (_, _) => (Nil, false)
    }._2
  }
}
