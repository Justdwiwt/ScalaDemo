package leetCode

object Solution_926 {
  def minFlipsMonoIncr(S: String): Int = {
    val r = S./:((0, 0)) {
      case ((endsZero, endsOne), '0') => (endsZero, endsZero.min(endsOne) + 1)
      case ((endsZero, endsOne), '1') => (endsZero + 1, endsZero.min(endsOne))
      case ((_, _), _) => (0, 0)
    }
    r._1.min(r._2)
  }
}
