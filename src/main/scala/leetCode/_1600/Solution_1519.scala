package leetCode._1600

object Solution_1519 {
  private val labelA = 'a'

  private def addVectors(a: Vector[Int], b: Vector[Int]): Vector[Int] =
    a.zip(b).map { case (a, b) => a + b }

  def countSubTrees(n: Int, edges: Array[Array[Int]], _labels: String): Array[Int] = {
    val labels = _labels.toVector
    val res = Array.fill(n)(0)
    lazy val groups = edges.toList.flatMap(a => List(a, a.reverse)).groupBy(_.head).mapValues(_.map(_(1)))

    def f(n: Int, parent: Int): Vector[Int] = {
      lazy val children: Seq[Int] = groups(n).filterNot(_ == parent)
      lazy val v0: Vector[Int] =
        if (children.isEmpty) Vector.fill(26)(0)
        else children.map(f(_, n)).reduceLeft(addVectors)
      lazy val idx = labels(n) - labelA
      res(n) = v0(idx) + 1
      v0.updated(idx, 1 + v0(idx))
    }

    f(0, -1)
    res
  }
}
