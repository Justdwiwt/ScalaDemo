package leetCode._2000

object Solution_1905 {
  def countSubIslands(grid1: Array[Array[Int]], grid2: Array[Array[Int]]): Int = {
    val (djs1, djs2) = (new DJS[(Int, Int)], new DJS[(Int, Int)])
    grid1.indices.foreach(i => grid1.head.indices.foreach(j => {
      if (grid1(i)(j) != 0) djs1.add((i, j))
      if (grid2(i)(j) != 0) djs2.add((i, j))
    }))
    grid1.indices.foreach(i => grid1.head.indices.foreach(j => {
      if ((i + 1) < grid1.length && grid1(i)(j) + grid1(i + 1)(j) == 2) djs1.join((i, j), (i + 1, j))
      if ((j + 1) < grid1.head.length && grid1(i)(j) + grid1(i)(j + 1) == 2) djs1.join((i, j), (i, j + 1))
      if ((i + 1) < grid2.length && grid2(i)(j) + grid2(i + 1)(j) == 2) djs2.join((i, j), (i + 1, j))
      if ((j + 1) < grid2.head.length && grid2(i)(j) + grid2(i)(j + 1) == 2) djs2.join((i, j), (i, j + 1))
    }))

    djs2
      .djs
      .keys
      .toList
      .map(x => djs2.getRoot(x) -> x)
      .groupBy(_._1)
      .mapValues(_.map(_._2))
      .filter { case (_, v) => v.forall { case (i, j) => grid1(i)(j) + grid2(i)(j) == 2 } }
      .count { case (_, v) =>
        lazy val r0 = djs1.getRoot(v.head._1, v.head._2)
        v.tail.isEmpty || v.tail.forall { case (i, j) => djs1.getRoot(i, j) == r0 }
      }
  }
}

class DJS[A] {
  val djs = collection.mutable.Map.empty[A, A]

  @scala.annotation.tailrec
  private def _getRoot(a: A, depth: Int = 0): (A, Int) =
    if (djs(a) == a) (a, depth)
    else _getRoot(djs(a), depth + 1)

  def add(a: A): DJS[A] = {
    djs(a) = a
    this
  }

  @scala.annotation.tailrec
  private def _addWithParent(a: A, p: A): DJS[A] = {
    val oldP = djs(a)
    djs(a) = p
    if (oldP != a) _addWithParent(oldP, p)
    else this
  }

  def getRoot(a: A): A =
    _getRoot(a: A)._1

  def join(a: A, b: A): DJS[A] = {
    if (!djs.contains(a)) add(a)
    if (!djs.contains(b)) add(b)
    lazy val (ra, rb) = (_getRoot(a), _getRoot(b))
    if (ra._1 != rb._1) {
      if (ra._2 < rb._2) {
        _addWithParent(rb._1, ra._1)
        _addWithParent(b, ra._1)
      }
      else {
        _addWithParent(ra._1, rb._1)
        _addWithParent(a, rb._1)
      }
    }
    this
  }

  override def toString: String = djs.toString
}
