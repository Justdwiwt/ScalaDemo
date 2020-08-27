package leetCode

object Solution_891 {
  val mod = 1000000007

  def sumSubseqWidths(A: Array[Int]): Int = solve2(getpow2(A.length, Nil).reverse.toArray)(A.sorted)

  def solve2(table: Array[Int])(sa: Array[Int]): Int = cumSolver(table)(sa, cum(sa), cum(sa.reverse))

  def cumSolver(table: Array[Int])(sa: Array[Int], fcum: Array[Int], lcum: Array[Int]): Int = (0 until sa.length - 1).toArray.map(pn => ((lcum(pn) - fcum(pn)) * BigInt(table(pn)) % mod).toInt).foldLeft(0)(modAdd)

  def cum(A: Array[Int]): Array[Int] = {
    if (A.length == 0) Array[Int]()
    else {
      val res = Array.fill(A.length)(A(0))
      (1 until A.length).foreach(i => res(i) = A(i) + res(i - 1))
      res
    }
  }

  def modAdd(x: Int, y: Int): Int = (x + y) % mod

  @scala.annotation.tailrec
  def getpow2(n: Int, list: List[Int]): List[Int] = (n, list) match {
    case (_, Nil) => getpow2(n - 1, List(1))
    case (x: Int, h :: t) if x > 0 => getpow2(x - 1, (h * 2 % mod) :: h :: t)
    case (0, _ :: _) => list
  }

  def solve(table: Array[Int])(sa: Array[Int]): Int = sa.indices.flatMap(i => f(i, sa.length)(i + 1, Nil)).map(g(sa, table)).foldLeft(0)(modAdd)

  @scala.annotation.tailrec
  def f(i: Int, n: Int)(j: Int, acc: List[(Int, Int)]): List[(Int, Int)] = if (j < n) f(i, n)(j + 1, (i, j) :: acc) else acc

  def g(A: Array[Int], table: Array[Int])(x: (Int, Int)): Int = (table(x._2 - x._1 - 1) * BigInt(A(x._2) - A(x._1)) % mod).toInt
}
