package leetCode._900

import scala.collection.mutable

object Solution_818 {
  def racecar(target: Int): Int = {
    val st = mutable.Set[(Int, Int)]() ++ Seq((0, 1))
    val seq = mutable.ListBuffer[(Int, Int)]() ++ Seq((0, 1))

    def f(p: (Int, Int)): Option[(Int, Int)] = p match {
      case nextPos@(pos, _) if (pos - target).abs < target && !st.contains(p) => Some(nextPos)
      case _ => None
    }

    var level = 0
    var sol: Option[Int] = None
    while (sol.isEmpty && seq.nonEmpty) {
      val xs = seq.toList
      seq.clear
      xs.foreach(p => {
        (p._1, p._2) match {
          case (pos, _) if pos == target => sol = Some(level)
          case (pos, speed) =>
            f((pos + speed, speed * 2)) match {
              case Some(nextPos) =>
                st ++= Seq(nextPos)
                seq ++= Seq(nextPos)
              case _ =>
            }
            f((pos, if (0 < speed) -1 else 1)) match {
              case Some(nextPos) =>
                st ++= Seq(nextPos)
                seq ++= Seq(nextPos)
              case _ =>
            }
        }
      })
      level += 1
    }
    sol match {
      case None => -1
      case Some(k) => k
    }
  }
}
