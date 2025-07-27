package leetCode._3600

object Solution_3600 {
  def maxStability(n: Int, edges: Array[Array[Int]], k: Int): Int = {
    case class Edge(u: Int, v: Int, w: Int, must: Boolean)
    class UnionFind(n: Int) {
      private val parent = (0 until n).toArray
      var cc: Int = n

      def find(x: Int): Int =
        if (parent(x) == x) x
        else {
          parent(x) = find(parent(x))
          parent(x)
        }

      def merge(x: Int, y: Int): Boolean = {
        val fx = find(x)
        val fy = find(y)
        if (fx == fy) false
        else {
          parent(fx) = fy
          cc -= 1
          true
        }
      }
    }

    val es = edges.map(e => Edge(e.head, e(1), e(2), e(3) == 1))
    val uf = new UnionFind(n)
    val allUf = new UnionFind(n)

    val mustEdges = es.filter(_.must)
    val minS1Opt = mustEdges.foldLeft(Option(Int.MaxValue)) {
      case (Some(minS), Edge(u, v, w, _)) => allUf.merge(u, v)
        if (uf.merge(u, v)) Some(minS min w) else None
      case (None, _) => None
    }

    es.foreach(e => allUf.merge(e.u, e.v))

    if (minS1Opt.isEmpty || allUf.cc > 1) -1
    else {
      val minS1 = minS1Opt.get
      if (uf.cc == 1) minS1
      else {
        val nonMust = es.filter(!_.must).sortBy(-_.w)
        val selected = nonMust.collect {
          case Edge(u, v, w, _) if uf.merge(u, v) => w
        }

        if (selected.isEmpty) -1
        else {
          val opt1 = minS1
          val opt2 = selected.last * 2
          val opt3 = if (k < selected.length) selected(selected.length - 1 - k) else Int.MaxValue
          List(opt1, opt2, opt3).min
        }
      }
    }
  }
}
