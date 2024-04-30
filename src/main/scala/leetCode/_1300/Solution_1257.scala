package leetCode._1300

import scala.collection.mutable

object Solution_1257 {
  def findSmallestRegion(regions: List[List[String]], r1: String, r2: String): String = {
    val q = mutable.Set.empty[String]
    val m = regions.flatMap {
      case j :: r => r.map(_ -> j)
      case Nil => Nil
    }.toMap

    @scala.annotation.tailrec
    def findParent(region: String): Unit =
      if (m.contains(region)) {
        q.add(region)
        findParent(m(region))
      }

    findParent(r1)

    @scala.annotation.tailrec
    def findCommonParent(region: String): String =
      if (q.contains(region)) region
      else if (m.contains(region)) findCommonParent(m(region))
      else region

    findCommonParent(r2)
  }
}
