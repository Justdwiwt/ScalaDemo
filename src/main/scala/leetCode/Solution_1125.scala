package leetCode

import scala.collection.mutable

object Solution_1125 {
  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val map = req_skills.zipWithIndex.toMap
    val cand = people.map(_./:(0)((acc, skill) => acc | (1 << map(skill))))
    val cache = mutable.Map[(Int, Int), List[Int]]()

    def f(i: Int, mask: Int): List[Int] = mask match {
      case 0 => List.empty
      case _ if i == people.length => List.fill(100)(0)
      case _ if (mask & cand(i)) == 0 => f(i + 1, mask)
      case _ if cache.contains((i, mask)) => cache((i, mask))
      case _ =>
        val res = List(f(i + 1, mask), i :: f(i + 1, mask & ~cand(i))).minBy(_.length)
        cache((i, mask)) = res
        res
    }

    f(0, (1 << req_skills.length) - 1).toArray
  }
}
