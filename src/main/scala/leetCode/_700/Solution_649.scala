package leetCode._700

import scala.collection.mutable

object Solution_649 {
  def predictPartyVictory(senate: String): String = {
    val (radiant, dire) = senate.zipWithIndex./:(mutable.Queue[Int](), mutable.Queue[Int]())((acc, cur) => {
      if (cur._1 == 'R') acc._1 += cur._2
      else acc._2 += cur._2
      acc
    })
    while (radiant.nonEmpty && dire.nonEmpty) {
      val r = radiant.dequeue
      val d = dire.dequeue
      if (r < d) radiant += (r + senate.length)
      else dire += (d + senate.length)
    }
    if (radiant.isEmpty) "Dire" else "Radiant"
  }
}
