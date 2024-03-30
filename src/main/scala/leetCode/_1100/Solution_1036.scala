package leetCode._1100

object Solution_1036 {
  private type Cell = (Int, Int)

  def isEscapePossible(blocked: Array[Array[Int]], source: Array[Int], target: Array[Int]): Boolean = f(
    blocked.map(b => b.head -> b.last).toSet,
    (source.head, source.last),
    (target.head, target.last)
  )

  @scala.annotation.tailrec
  private def f(blocks: Set[Cell], s: Cell, t: Cell): Boolean =
    if (blocks.isEmpty) true
    else {
      val ConnectedResp(connected, newBlocks, tl, br) =
        getConnected(Set(blocks.head), ConnectedResp(Set.empty, blocks, (1000000, -1), (-1, 1000000)))

      val sIsInside = isInside(tl, br, s)
      val tIsInside = isInside(tl, br, t)

      val passed =
        if (sIsInside && tIsInside) {
          val vis = Array.fill(br._1 - tl._1 + 3)(Array.fill(tl._2 - br._2 + 3)(false))
          wayToExists(connected, Set(s), t, tl, br, vis)
        }
        else {
          val vis = Array.fill(br._1 - tl._1 + 1)(Array.fill(tl._2 - br._2 + 1)(false))
          if (sIsInside) wayOutsideExists(connected, Set(s), tl, br, vis)
          else if (tIsInside) wayOutsideExists(connected, Set(t), tl, br, vis)
          else true
        }

      if (passed) f(newBlocks, s, t)
      else false
    }

  private case class ConnectedResp(connected: Set[Cell], rest: Set[Cell], topLeft: Cell, bottomRight: Cell)

  @scala.annotation.tailrec
  private def getConnected(q: Set[Cell], res: ConnectedResp): ConnectedResp =
    if (q.isEmpty) res
    else {
      val rest = res.rest -- q
      val (newTopLeft, newTopRight) = q./:(res.topLeft, res.bottomRight) { case ((t, b), p) =>
        ((t._1.min(p._1), t._2.max(p._2)), (b._1.max(p._1), b._2.min(p._2)))
      }

      getConnected(
        q.flatMap(getNeighbours(_).filter(rest.contains)),
        ConnectedResp(res.connected ++ q, rest, newTopLeft, newTopRight)
      )
    }

  private def getNeighbours(p: Cell): Seq[Cell] = (-1 to 1)
    .flatMap(i => (-1 to 1).map(j => (p._1 + i, p._2 + j)))

  private def isInside(tl: Cell, br: Cell, p: Cell): Boolean =
    p._1 >= tl._1 && p._1 <= br._1 && p._2 <= tl._2 && p._2 >= br._2

  @scala.annotation.tailrec
  private def wayToExists(blocks: Set[Cell], s: Set[Cell], t: Cell, tl: Cell, br: Cell, vis: Array[Array[Boolean]]): Boolean =
    if (s.isEmpty) false
    else {
      s.foreach(c => vis(c._1 - tl._1 + 1)(c._2 - br._2 + 1) = true)

      val np = s
        .flatMap(getMoves)
        .filter(p => {
          p._1 >= tl._1 - 1 &&
            p._1 <= br._1 + 1 &&
            p._2 <= tl._2 + 1 &&
            p._2 >= br._2 - 1 &&
            !vis(p._1 - tl._1 + 1)(p._2 - br._2 + 1) &&
            !blocks.contains(p)
        })

      if (np.contains(t)) true
      else wayToExists(blocks, np, t, tl, br, vis)
    }

  private def getMoves(p: Cell): Seq[(Int, Int)] =
    Seq((p._1 - 1, p._2), (p._1 + 1, p._2), (p._1, p._2 - 1), (p._1, p._2 + 1))
      .filter(c => c._1 >= 0 && c._1 < 1000000 && c._2 >= 0 && c._2 < 1000000)

  @scala.annotation.tailrec
  private def wayOutsideExists(blocks: Set[Cell], p: Set[Cell], tl: Cell, br: Cell, vis: Array[Array[Boolean]]): Boolean =
    if (p.isEmpty) false
    else {
      p.foreach(c => vis(c._1 - tl._1)(c._2 - br._2) = true)
      val np = p.flatMap(getMoves)

      if (np.exists(!isInside(tl, br, _))) true
      else wayOutsideExists(blocks, np.filter(p => !vis(p._1 - tl._1)(p._2 - br._2) && !blocks.contains(p)), tl, br, vis)
    }
}
