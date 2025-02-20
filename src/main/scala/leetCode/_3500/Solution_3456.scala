package leetCode._3500

object Solution_3456 {
  def hasSpecialSubstring(s: String, k: Int): Boolean = {
    def isValidGroup(group: String): Boolean =
      group.length == k && group.distinct.length == 1

    s.foldLeft(List.empty[String])((acc, c) => acc match {
        case Nil => List(c.toString)
        case head :: tail if head.head == c => (head + c) :: tail
        case _ => c.toString :: acc
      })
      .reverse
      .exists(isValidGroup)
  }
}
