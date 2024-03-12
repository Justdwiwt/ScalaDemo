package leetCode._2700

object Solution_2696 {
  @scala.annotation.tailrec
  def minLength(s: String): Int = s.contains("AB") || s.contains("CD") match {
    case false => s.length
    case true if s.contains("AB") => minLength(s.replaceAll("AB", ""))
    case true if s.contains("CD") => minLength(s.replaceAll("CD", ""))
    case _ => s.length
  }
}
