package leetCode

object Solution_1790 {
  def areAlmostEqual(s1: String, s2: String): Boolean = {
    val res = scala.collection.mutable.ListBuffer[(Char, Char)]()
    s1.zip(s2).toList./:(res)((b, a) => if (a._1 != a._2) b += ((a._1, a._2)) else b)
    res.isEmpty || res.length == 2 && res.head._1 == res(1)._2 && res.head._2 == res(1)._1
  }
}
