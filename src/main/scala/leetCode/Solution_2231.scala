package leetCode

object Solution_2231 {
  private lazy val zero = '0'.toInt

  def largestInteger(num: Int): Int = {
    def sortXs(xs: Seq[(Int, Int)]): Seq[(Int, Int)] = {
      lazy val (ns, idx) = xs.unzip

      ns
        .sorted
        .reverse
        .zip(idx)
    }

    lazy val (es, os) = num
      .toString
      .map(_.toInt - zero)
      .zipWithIndex
      .partition(x => (x._1 & 1) == 0)

    (sortXs(es) ++ sortXs(os))
      .sortBy(_._2)
      .map(_._1)
      .mkString
      .toInt
  }
}
