package leetCode._1100

object Solution_1046 {
  def lastStoneWeight(stones: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(lst: List[Int]): Int = lst match {
      case List(n) => n
      case h :: s :: tl =>
        if (h == s) f(tl)
        else f(((h - s).abs +: tl).sortWith(_ > _))
      case _ => 0
    }

    f(stones.toList.sortWith(_ > _))
  }
}
