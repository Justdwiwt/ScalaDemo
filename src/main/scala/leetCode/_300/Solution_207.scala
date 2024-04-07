package leetCode._300

object Solution_207 {
  private val init = Map.empty[Int, Set[Int]]

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val pMap = prerequisites.foldLeft(init)((m, p) => m.updated(p.head, m.getOrElse(p.head, Set.empty) + p(1)))
    f((0 until numCourses).filter(!pMap.contains(_)).toList, pMap)
  }

  @scala.annotation.tailrec
  private def f(courses: List[Int], pMap: Map[Int, Set[Int]]): Boolean = (pMap.isEmpty, courses) match {
    case (true, _) => true
    case (_, Nil) => false
    case (_, c :: tail) =>
      val (nCourses, nMap) = pMap.iterator.foldLeft((tail, pMap)) { case ((nCourses, m), (k, set)) =>
        if (set == Set(c)) (k :: nCourses, m - k)
        else (nCourses, m.updated(k, set - c))
      }
      f(nCourses, nMap)
  }
}
