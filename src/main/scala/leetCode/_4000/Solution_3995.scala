package leetCode._4000

object Solution_3995 {
  def minCost(source: String, target: String, rules: List[List[String]], costs: Array[Int]): Int = {

    val adjusted = rules.zip(costs).map {
      case (rule, cost) =>
        cost + rule.head.count(_ == '*')
    }

    def isMatch(pattern: String, left: Int): Boolean =
      pattern.indices.forall(j => pattern(j) == '*' || pattern(j) == source(left + j))

    val n = source.length
    val inf = Int.MaxValue
    val f = Array.fill(n + 1)(inf)
    f(0) = 0

    source.indices.foreach(i => {
      if (source(i) == target(i)) f(i + 1) = f(i)

      rules.zip(adjusted).foreach {
        case (rule, cost) =>
          val replacement = rule(1)
          val left = i - replacement.length + 1

          if (
            left >= 0 &&
              f(left) != inf &&
              f(left) + cost < f(i + 1) &&
              replacement == target.substring(left, i + 1) &&
              isMatch(rule.head, left)
          ) f(i + 1) = f(left) + cost
      }
    })

    if (f(n) == inf) -1 else f(n)
  }
}
