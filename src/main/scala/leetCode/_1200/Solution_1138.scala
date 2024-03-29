package leetCode._1200

import scala.math.Integral.Implicits._

object Solution_1138 {
  def alphabetBoardPath(target: String): String = target.foldLeft("", 0, 0) { case ((path, x1, y1), char) =>
    val (x2, y2) = (char - 'a') /% 5
    val xMove = if (x1 < x2) "D" * (x2 - x1) else "U" * (x1 - x2)
    val yMove = if (y1 < y2) "R" * (y2 - y1) else "L" * (y1 - y2)
    val newMove = if (x2 == 5) s"$yMove$xMove" else xMove + yMove
    (path + newMove + "!", x2, y2)
  }._1
}
