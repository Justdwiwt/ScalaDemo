package leetCode

object Solution_1528 {
  def restoreString(s: String, indices: Array[Int]): String = {
    val c = new Array[Char](s.length)
    indices.indices.foreach(i => c(indices(i)) = s(i))
    new String(c)
  }
}
