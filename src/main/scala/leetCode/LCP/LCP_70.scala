package leetCode.LCP

object LCP_70 {
  def sandyLandManagement(size: Int): Array[Array[Int]] = {
    var n = 2 * size
    var res = List.empty[List[Int]]
    var i = size
    while (i > 1) {
      res = res ++ (1 until n by 2).map(List(i, _)).toList
      if (i >= 3) res = res :+ List(i - 1, 2)
      i -= 2
      if (i >= 2) res = res ++ (3 until n - 4 by 2).map(List(i, _)).toList
      if (i >= 3) res = res :+ List(i - 1, 1)
      i -= 2
      n -= 8
    }
    (res :+ List(1, 1)).map(_.toArray).toArray
  }
}
