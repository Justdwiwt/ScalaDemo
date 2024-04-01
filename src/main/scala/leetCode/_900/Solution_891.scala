package leetCode._900

object Solution_891 {
  val M = 1000000007

  def sumSubseqWidths(A: Array[Int]): Int =
    solve2(getPow2(A.length, Nil).reverse.toArray)(A.sorted)

  private def solve2(table: Array[Int])(sa: Array[Int]): Int =
    cumSolver(table)(sa, cum(sa), cum(sa.reverse))

  private def cumSolver(table: Array[Int])(sa: Array[Int], fCum: Array[Int], lCum: Array[Int]): Int =
    sa.indices.dropRight(1).toArray.map(pn => ((lCum(pn) - fCum(pn)) * BigInt(table(pn)) % M).toInt)./:(0)(modAdd)

  private def cum(A: Array[Int]): Array[Int] =
    if (A.isEmpty) Array[Int]()
    else {
      val res = Array.fill(A.length)(A.head)
      A.indices.drop(1).foreach(i => res(i) = A(i) + res(i - 1))
      res
    }

  private def modAdd(x: Int, y: Int): Int =
    (x + y) % M

  @scala.annotation.tailrec
  private def getPow2(n: Int, list: List[Int]): List[Int] = (n, list) match {
    case (_, Nil) => getPow2(n - 1, List(1))
    case (x: Int, h :: t) if x > 0 => getPow2(x - 1, (h * 2 % M) :: h :: t)
    case (0, _ :: _) => list
  }

  def solve(table: Array[Int])(sa: Array[Int]): Int =
    sa.indices.flatMap(i => f(i, sa.length)(i + 1, Nil)).map(g(sa, table))./:(0)(modAdd)

  @scala.annotation.tailrec
  private def f(i: Int, n: Int)(j: Int, acc: List[(Int, Int)]): List[(Int, Int)] =
    if (j < n) f(i, n)(j + 1, (i, j) :: acc) else acc

  private def g(A: Array[Int], table: Array[Int])(x: (Int, Int)): Int =
    (table(x._2 - x._1 - 1) * BigInt(A(x._2) - A(x._1)) % M).toInt
}
