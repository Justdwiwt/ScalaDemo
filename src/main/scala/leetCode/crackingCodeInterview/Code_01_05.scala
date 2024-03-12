package leetCode.crackingCodeInterview

object Code_01_05 {
  def oneEditAway(first: String, second: String): Boolean = {
    @scala.annotation.tailrec
    def shrink(l1: List[Char], l2: List[Char], n: Int = 1): Boolean = (l1, l2) match {
      case (h1 :: t1, h2 :: t2) =>
        if (h1 == h2) shrink(t1, t2, n)
        else {
          if (n == 1) shrink(l1.reverse, l2.reverse, 0)
          else check(l1, l2)
        }
      case (_, _) => check(l1, l2)
    }

    def check(l1: List[Char], l2: List[Char]): Boolean = (l1, l2) match {
      case (Nil, Nil) => true
      case (_ :: Nil, Nil) => true
      case (Nil, _ :: Nil) => true
      case (_ :: Nil, _ :: Nil) => true
      case (_, _) => false
    }

    shrink(first.toList, second.toList)
  }
}
