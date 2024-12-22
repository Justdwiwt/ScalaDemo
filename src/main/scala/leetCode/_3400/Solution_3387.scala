package leetCode._3400

object Solution_3387 {
  def maxAmount(initialCurrency: String, pairs1: List[List[String]], rates1: Array[Double], pairs2: List[List[String]], rates2: Array[Double]): Double = {

    def dfs(curr: String, parent: String, value: Double, graph: Map[String, List[(String, Double)]], dis: Map[String, Double]): Map[String, Double] = {
      val updatedDis = dis + (curr -> value)
      graph.getOrElse(curr, List()).foldLeft(updatedDis) { case (accDis, (nextCurrency, rate)) =>
        if (nextCurrency != parent) dfs(nextCurrency, curr, value * rate, graph, accDis) else accDis
      }
    }

    val graph1: Map[String, List[(String, Double)]] = pairs1.zip(rates1).foldLeft(Map.empty[String, List[(String, Double)]]) {
      case (graph, (pair, rate)) =>
        val cur1 = pair.head
        val cur2 = pair(1)
        graph + (cur1 -> ((cur2, rate) :: graph.getOrElse(cur1, Nil))) + (cur2 -> ((cur1, 1 / rate) :: graph.getOrElse(cur2, Nil)))
    }

    val dis1 = dfs(initialCurrency, "", 1.0, graph1, Map.empty[String, Double])

    val graph2: Map[String, List[(String, Double)]] = pairs2.zip(rates2).foldLeft(Map.empty[String, List[(String, Double)]]) {
      case (graph, (pair, rate)) =>
        val currency1 = pair.head
        val currency2 = pair(1)
        graph + (
          currency1 -> ((currency2, rate) :: graph.getOrElse(currency1, Nil))) +
          (currency2 -> ((currency1, 1 / rate) :: graph.getOrElse(currency2, Nil)))
    }

    val dis2 = dfs(initialCurrency, "", 1.0, graph2, Map.empty[String, Double])

    dis1.foldLeft(1.0) { case (maxRate, (cur, rate1)) =>
      dis2.get(cur) match {
        case Some(rate2) => maxRate.max(rate1 / rate2)
        case None => maxRate
      }
    }
  }
}
