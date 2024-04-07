package leetCode._300

object Solution_255 {
  def verifyPreorder(preorder: Array[Int]): Boolean = {
    def f(preorder: List[Int], minVal: Int): Boolean = preorder match {
      case Nil => true
      case v :: tail =>
        if (v < minVal) false
        else {
          val (smaller, larger) = tail.span(_ < v)
          f(smaller, minVal) && f(larger, v)
        }
    }

    f(preorder.toList, Int.MinValue)
  }
}
