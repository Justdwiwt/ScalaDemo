package leetCode

object Solution_263 {
  def isUgly(n: Int): Boolean = {
    @scala.annotation.tailrec
    def f(n: Int, remove: Int): Int =
      if (n % remove != 0) n
      else f(n / remove, remove)

    if (n < 1) false
    else 1 == List(2, 3, 5)./:(n)(f)
  }
}
