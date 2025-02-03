package leetCode._3500

object Solution_3437 {
  def permute(n: Int): Array[Array[Int]] = {
    def backtrack(curr: List[Int], used: Array[Boolean]): List[List[Int]] = {
      if (curr.length == n) List(curr)
      else (1 to n).flatMap(i => if (!used(i - 1) && (curr.isEmpty || curr.lastOption.fold(true)(_ % 2 != i % 2))) {
        used(i - 1) = true
        val res = backtrack(curr :+ i, used)
        used(i - 1) = false
        res
      } else Nil).toList
    }

    backtrack(Nil, Array.fill(n)(false)).map(_.toArray).toArray
  }
}
