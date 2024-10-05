package leetCode._3400

object Solution_3307 {
  private val arr: Array[Long] = (0 until 63).map(Math.pow(2, _).toLong).toArray

  def kthCharacter(k: Long, operations: Array[Int]): Char = {
    val idxList = f(k)
    idxList.foldLeft('a')((cur, idx) => if (operations(idx) == 1) ((cur - 'a' + 1) % 26 + 'a').toChar else cur)
  }

  private def f(k: Long): List[Int] = {
    if (k <= 1) return Nil

    arr
      .indices
      .reverse
      .collectFirst { case i if k > arr(i) => (i, k - arr(i)) }
      .map { case (i, newK) => i :: f(newK) }
      .getOrElse(Nil)
  }
}
