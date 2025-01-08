package leetCode._3500

object Solution_3407 {
  def hasMatch(s: String, p: String): Boolean = {
    val parts: Option[(String, String)] = p.indexOf('*') match {
      case -1 => None
      case idx => Some((p.substring(0, idx), p.substring(idx + 1)))
    }

    parts.exists { case (prefix, suffix) =>
      s.indexOf(prefix) match {
        case -1 => false
        case prefixIndex => s.substring(prefixIndex + prefix.length).contains(suffix)
      }
    }
  }
}
