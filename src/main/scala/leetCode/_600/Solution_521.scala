package leetCode._600

object Solution_521 {
  def findLUSlength(a: String, b: String): Int = if (a == b) -1 else a.length.max(b.length)
}
