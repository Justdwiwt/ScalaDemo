package leetCode.LCP

object LCP_80 {
  // fixme: case 62/86 stack overflow
  private var g: Map[Int, List[Int]] = _

  def evolutionaryRecord(parents: Array[Int]): String = {
    g = parents.zipWithIndex.tail.groupBy(_._1).mapValues(_.map(_._2).toList)

    def dfs(x: Int): String = {
      val a = g.getOrElse(x, List.empty).map(dfs).sorted
      "0" + a.mkString + "1"
    }

    dfs(0).substring(1).replaceAll("1+$", "")
  }
}
