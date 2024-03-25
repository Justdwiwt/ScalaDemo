package leetCode._1600

object Solution_1585 {
  def isTransformable(s: String, t: String): Boolean = {
    def get(data: Map[Int, Int])(i: Int, j: Int, k: Int, l: Int, r: Int): Int = {
      if (j == k || l == r) Int.MaxValue
      else if (l == j && r == k) data(i)
      else {
        val (m, il, ir) = ((j + k) / 2, 2 * i + 1, 2 * i + 2)
        get(data)(il, j, m, m.min(l), m.min(r)).min(get(data)(ir, m, k, m.max(l), m.max(r)))
      }
    }

    def put(data: Map[Int, Int])(i: Int, j: Int, k: Int, t: Int, v: Int): Map[Int, Int] = {
      if (j + 1 == k) data + (i -> v)
      else {
        val (m, il, ir) = ((j + k) / 2, 2 * i + 1, 2 * i + 2)
        val newData = if (t < m) put(data)(il, j, m, t, v) else put(data)(ir, m, k, t, v)
        newData + (i -> newData(il).min(newData(ir)))
      }
    }

    val sWithInd = s.map(_ - '0').zipWithIndex
    val segTree = sWithInd.foldLeft(Map[Int, Int]().withDefaultValue(Int.MaxValue)) {
      case (tree, (x, i)) => put(tree)(0, 0, s.length, i, x)
    }
    val indices = sWithInd.groupBy(_._1).mapValues(_.map(_._2).toVector)

    t.map(_ - '0').iterator.scanLeft(segTree, indices, true) { case ((tree, ind, _), digit) =>
      ind.get(digit) match {
        case Some(i +: tail) if get(tree)(0, 0, s.length, 0, i) >= digit =>
          (put(tree)(0, 0, s.length, i, Int.MaxValue), ind + (digit -> tail), true)
        case _ => (tree, ind, false)
      }
    }.forall(_._3)
  }
}
