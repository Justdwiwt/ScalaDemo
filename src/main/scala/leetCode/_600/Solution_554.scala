package leetCode._600

import scala.collection.mutable

object Solution_554 {
  def leastBricks(wall: List[List[Int]]): Int = {
    val m = mutable.Map.empty[Int, Int]

    @scala.annotation.tailrec
    def f(row: List[Int], offset: Int): Unit = row match {
      case Nil =>
      case _ :: Nil =>
      case hd :: tl =>
        val newOffset = offset + hd
        m += newOffset -> (m.getOrElse(newOffset, 0) + 1)
        f(tl, newOffset)
    }

    wall.foreach(row => f(row, 0))
    wall.length - m.values./:(0)(_.max(_))
  }
}
