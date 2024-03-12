package leetCode._700

object Solution_632 {
  def smallestRange(nums: List[List[Int]]): Array[Int] = {
    val seq = nums
      .zipWithIndex
      .flatMap(in => in._1.map(_ -> in._2))
      .groupBy(_._1)
      .mapValues(_.map(_._2))
      .toSeq
      .sortBy(_._1)

    findMinInt(seq, Map.empty[Int, Int], 0, 0, nums.length, Array(seq.head._1, seq.last._1))
  }

  @scala.annotation.tailrec
  def findMinInt(seq: Seq[(Int, Seq[Int])], m: Map[Int, Int], l: Int, r: Int, need: Int, res: Array[Int]): Array[Int] =
    if (need == 0) {
      val (newM, deltaNeed) = removeLeft(seq, m, l)
      val ans = mnInt(seq, l, r - 1, res)
      findMinInt(seq, newM, l + 1, r, deltaNeed, ans)
    }
    else if (r == seq.length) res
    else {
      val (newM, deltaNeed) = addRight(seq, m, r)
      findMinInt(seq, newM, l, r + 1, need - deltaNeed, res)
    }

  def removeLeft(seq: Seq[(Int, Seq[Int])], m: Map[Int, Int], l: Int): (Map[Int, Int], Int) =
    seq(l)._2./:((m, 0)) { case ((m, d), in) =>
      if (m(in) == 1) (m - in, d + 1)
      else (m + (in -> (m(in) - 1)), d)
    }

  def addRight(seq: Seq[(Int, Seq[Int])], m: Map[Int, Int], r: Int): (Map[Int, Int], Int) =
    seq(r)._2./:((m, 0)) { case ((m, d), in) =>
      if (m.contains(in)) (m + (in -> (m(in) + 1)), d)
      else (m + (in -> 1), d + 1)
    }

  def mnInt(seq: Seq[(Int, Seq[Int])], l: Int, r: Int, res: Array[Int]): Array[Int] =
    if (res(1) - res.head > seq(r)._1 - seq(l)._1) Array(seq(l)._1, seq(r)._1)
    else res
}
