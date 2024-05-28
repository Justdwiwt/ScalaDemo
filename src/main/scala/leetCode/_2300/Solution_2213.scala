package leetCode._2300

object Solution_2213 {
  private case class Node(l: Int, r: Int, len: Int, var cl: Char, var cr: Char, var lMx: Int, var rMx: Int, var tMx: Int)

  private var g: Array[Char] = _
  private val N = 100010
  private val tr = new Array[Node](4 * N)

  private def pushUp(u: Node, l: Node, r: Node): Unit = {
    if (l.tMx == l.len && l.cr == r.cl) u.lMx = l.len + r.lMx
    else u.lMx = l.lMx

    if (r.tMx == r.len && r.cl == l.cr) u.rMx = r.len + l.rMx
    else u.rMx = r.rMx

    u.tMx = l.tMx.max(r.tMx)
    if (l.cr == r.cl) u.tMx = u.tMx.max(l.rMx + r.lMx)
  }

  private def pushUp(u: Int): Unit = {
    pushUp(tr(u), tr(u << 1), tr(u << 1 | 1))
  }

  private def build(u: Int, l: Int, r: Int): Unit = {
    if (l == r) {
      tr(u) = Node(l, r, r - l + 1, g(l), g(r), 1, 1, 1)
    } else {
      tr(u) = Node(l, r, r - l + 1, g(l), g(r), 0, 0, 0)
      val mid = l + r >> 1
      build(u << 1, l, mid)
      build(u << 1 | 1, mid + 1, r)
      pushUp(u)
    }
  }

  private def modify(u: Int, x: Int, v: Char): Unit = {
    if (tr(u).l == x && tr(u).r == x) {
      tr(u).cl = v
      tr(u).cr = v
    } else {
      if (tr(u).l == x) tr(u).cl = v
      if (tr(u).r == x) tr(u).cr = v
      val mid = tr(u).l + tr(u).r >> 1
      if (x <= mid) modify(u << 1, x, v)
      else modify(u << 1 | 1, x, v)
      pushUp(u)
    }
  }

  def longestRepeating(s: String, query: String, idx: Array[Int]): Array[Int] = {
    val n = s.length
    g = (" " + s).toCharArray
    build(1, 1, n)

    val k = query.length()
    val res = Array.fill(k)(0)
    (0 until k).foreach(i => {
      modify(1, idx(i) + 1, query(i))
      res(i) = tr(1).tMx
    })
    res
  }
}
