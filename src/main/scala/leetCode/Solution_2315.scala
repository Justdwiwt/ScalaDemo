package leetCode

object Solution_2315 {
  def countAsterisks(s: String): Int = s./:((false, 0)) { case ((pair, cnt), c) =>
    c match {
      case '|' => !pair -> cnt
      case '*' => pair -> (if (pair) cnt else cnt + 1)
      case _ => pair -> cnt
    }
  }._2
}
