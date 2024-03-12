package leetCode._1100

object Solution_1023 {
  def camelMatch(queries: Array[String], pattern: String): List[Boolean] = queries.map(query => {
    val (fp, fq) = query./:((pattern, "")) {
      case ((p, r), c) => if (p.isEmpty) (p, r + c)
      else {
        val isMatch = p.head == c
        val rq = if (isMatch) p.tail else p
        val rr = if (isMatch) r else r + c
        (rq, rr)
      }
    }
    fp.isEmpty && fq.forall(c => c.isLower)
  }).toList
}
