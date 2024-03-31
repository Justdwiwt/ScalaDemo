package leetCode._1000

object Solution_916 {
  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    val reqs = ('a' to 'z').map(l => l -> B.map(_.count(_ == l)).max)
    A.toList.filter(w => reqs.forall { case (l, c) => w.count(_ == l) >= c })
  }
}
