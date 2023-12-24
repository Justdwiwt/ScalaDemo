package leetCode

object Solution_2961 {
  def getGoodIndices(variables: Array[Array[Int]], target: Int): List[Int] = {

    def f(arr: Array[Int]): Int = {
      val (a, b, c, m) = (arr.head, arr(1), arr(2), arr(3))
      val fst = List.fill(b)(a).reduce((x, y) => (x * y) % 10) % 10
      val snd = List.fill(c)(fst).reduce((x, y) => (x * y) % m) % m
      snd
    }

    def g(arr: Array[Int], target: Int): Boolean =
      f(arr) == target

    variables.zipWithIndex.collect { case (a, i) if g(a, target) => i }.toList
  }
}
