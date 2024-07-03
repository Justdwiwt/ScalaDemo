package leetCode._2000

object Solution_1982 {
  private def findOne(pos: IndexedSeq[Int]): Option[(Int, IndexedSeq[Int])] = {
    val piv = pos(1) - pos.head
    val red = pos.foldLeft((IndexedSeq.empty[Int], 0)) {
      case ((seq, idx), cur) =>
        if (idx < seq.length && cur == seq(idx) + piv) (seq, idx + 1)
        else (seq :+ cur, idx)
    }._1
    Some(if (red.contains(0)) (piv, red) else (-piv, red.map(_ + piv)))
  }

  def recoverArray(n: Int, pos: Array[Int]): Array[Int] = {
    var remainingSeq = pos.sorted.toIndexedSeq
    var res = List.empty[(Int, IndexedSeq[Int])]

    while (res.length < n) {
      findOne(remainingSeq) match {
        case Some((piv, seq)) =>
          res = res :+ (piv, seq)
          remainingSeq = seq.toIndexedSeq
        case None =>
          throw new RuntimeException("Failed to recover the array")
      }
    }

    res.map(_._1).toArray
  }
}
