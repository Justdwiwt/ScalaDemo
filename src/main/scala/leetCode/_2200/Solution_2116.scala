package leetCode._2200

object Solution_2116 {
  def canBeValid(s: String, locked: String): Boolean = {
    val str = s.zip(locked.map(_ == '1')).view

    if (str.size % 2 == 1) return false
    val countOpen = str.count { case (c, l) => l && c == '(' }
    val countClose = str.count { case (c, l) => l && c == ')' }
    val start = (true, 0, 0, 0, countOpen, countClose, str.size - countOpen - countClose)

    val r = str.foldLeft(start) { case ((res, openHead, closeHead, unHead, openTail, closeTail, unTail), (c, l)) =>
      (c, l) match {
        case (_, false) =>
          (res && (closeHead <= openHead + unHead + 1 && openTail <= closeTail + unTail - 1),
            openHead, closeHead, unHead + 1, openTail, closeTail, unTail - 1)
        case ('(', _) =>
          (res && (closeHead <= openHead + 1 + unHead && openTail - 1 <= closeTail + unTail),
            openHead + 1, closeHead, unHead, openTail - 1, closeTail, unTail)
        case (')', _) =>
          (res && (closeHead + 1 <= openHead + unHead && openTail <= closeTail - 1 + unTail),
            openHead, closeHead + 1, unHead, openTail, closeTail - 1, unTail)
        case _ => (false, openHead, closeHead, unHead, openTail, closeTail, unTail)
      }
    }
    r._1
  }
}
