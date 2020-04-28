package leetCode

object Code_08_06 {
  def hanota(A: List[Int], B: List[Int], C: List[Int]): Unit = {
    def swap[T, S](tup: (T, S)): Any = tup match {
      case (x, y) => (y, x)
      case _ => println("error")
    }

    swap(A, C)
  }
}
