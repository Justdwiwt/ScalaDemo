package leetCode._900

object Solution_811 {
  def subdomainVisits(cpdomains: Array[String]): List[String] = cpdomains
    .map(_.split(" "))
    .map(a => (a.head, a(1)))
    .map(t => (t._1.toInt, t._2.split("\\.")))
    .map(t => (t._1, (t._2.length - 1 to 0 by -1).map(t._2.slice(_, t._2.length).mkString("."))))
    .flatMap(t => t._2.map((t._1, _)))
    .groupBy(_._2)
    .mapValues(_.map(_._1).sum)
    .map(t => t._2 + " " + t._1)
    .toList
}
