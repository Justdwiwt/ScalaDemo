package leetCode

object Solution_40 {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    def f(l: List[Int], t: Int): List[List[Int]] = l match {
      case _ if t < 0 => Nil
      case _ if t == 0 => List(Nil)
      case Nil => Nil
      case c :: cc => f(cc, t - c).map(c :: _) ++ f(cc, t)
    }

    f(candidates.toList.sorted, target).distinct
  }
}
