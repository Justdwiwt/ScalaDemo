package leetCode

object Solution_1047 {
  def removeDuplicates(S: String): String = {
    @scala.annotation.tailrec
    def func(list: List[Char], l2: List[Char]): String = {
      (list, l2) match {
        case (Nil, _) => l2.reverse.mkString
        case (h :: t, Nil) => func(t, h :: Nil)
        case (h1 :: t1, h2 :: t2) => if (h1 == h2) func(t1, t2) else func(t1, h1 :: l2)
      }
    }

    func(S.toList, Nil)
  }
}
