package leetCode._1000

object Solution_925 {
  @scala.annotation.tailrec
  def isLongPressedName(name: String, typed: String, last: Option[Char] = None): Boolean = (name.headOption, typed.headOption) match {
    case (None, None) => true
    case (Some(h1), Some(h2)) if h1 == h2 => isLongPressedName(name.drop(1), typed.drop(1), Some(h1))
    case (_, h2) if h2 == last => isLongPressedName(name, typed.drop(1), last)
    case _ => false
  }
}
