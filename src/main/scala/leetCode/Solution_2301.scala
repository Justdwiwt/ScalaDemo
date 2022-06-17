package leetCode

object Solution_2301 {
  def matchReplacement(s: String, sub: String, mappings: Array[Array[Char]]): Boolean = {
    val arr = Array.tabulate(256)(i => Array.tabulate(256)(j => i == j))
    mappings.withFilter { case Array(_, _) => true; case _ => false }.foreach { case Array(from, to) => arr(from)(to) = true }
    (0 to s.length - sub.length).exists(s0 => sub.indices.forall(i => arr(sub(i))(s(s0 + i))))
  }
}
