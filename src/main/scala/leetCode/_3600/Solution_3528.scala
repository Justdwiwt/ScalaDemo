package leetCode._3600

object Solution_3528 {
  def baseUnitConversions(conversions: Array[Array[Int]]): Array[Int] = {
    val M = 1000000007
    val map = conversions.foldLeft(Map.empty[Int, List[(Int, Int)]]) {
      case (acc, Array(source, target, conv)) =>
        acc.updated(source, acc.getOrElse(source, Nil) :+ (target, conv))
    }

    def dfs(i: Int, prod: Long, res: Map[Int, Long]): Map[Int, Long] =
      if (map.contains(i)) map(i).foldLeft(res) {
        case (acc, (target, conv)) =>
          val newProd = (prod * conv) % M
          dfs(target, newProd, acc.updated(target, newProd))
      }
      else res

    val resMap = dfs(0, 1L, Map(0 -> 1L))
    val res = new Array[Int](conversions.length + 1)
    resMap.foreach { case (ide, v) => res(ide) = (v % M).toInt }
    res
  }
}
