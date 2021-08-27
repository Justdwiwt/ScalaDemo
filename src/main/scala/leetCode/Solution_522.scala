package leetCode

object Solution_522 {
  def findLUSlength(strs: Array[String]): Int = {
    var res = -1

    def f(seq: String, str: String): Boolean = {
      var i = 0
      str.withFilter(_ => i < seq.length).foreach(ch => if (ch == seq(i)) i += 1)
      i == seq.length
    }

    strs.indices.foreach(j => if (!strs.zipWithIndex.exists(p => f(strs(j), p._1) && p._2 != j)) res = res.max(strs(j).length))
    res
  }
}
