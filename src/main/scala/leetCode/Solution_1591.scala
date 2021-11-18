package leetCode

object Solution_1591 {
  //  @scala.annotation.tailrec
  //  def isPrintable(target: Array[Array[Int]]): Boolean = {
  //    val m = target.length
  //    val n = target.headOption.map(_.length).getOrElse(0)
  //
  //    val colors = target
  //      .indices
  //      .flatMap(i => (0 until n).collect({ case j if target(i)(j) > 0 => target(i)(j) -> ((i, i), (j, j)) }))
  //      .groupMapReduce(_._1)(_._2)({
  //        case (((minRow1, maxRow1), (minCol1, maxCol1)), ((minRow2, maxRow2), (minCol2, maxCol2))) =>
  //          ((minRow1.min(minRow2), maxRow1.max(maxRow2)), (minCol1.min(minCol2), maxCol1.max(maxCol2)))
  //      })
  //
  //    if (colors.nonEmpty) {
  //      def isColorPrintable(color: Int) = colors(color) match {
  //        case ((minRow, maxRow), (minCol, maxCol)) => (minRow to maxRow)
  //          .forall(i => (minCol to maxCol)
  //            .forall(j => target(i)(j) == 0 || target(i)(j) == color))
  //      }
  //
  //      val printableColors = colors.keySet.filter(isColorPrintable)
  //
  //      if (printableColors.nonEmpty) {
  //        target.indices.foreach(i => (0 until n)
  //          .withFilter(j => printableColors.contains(target(i)(j)))
  //          .foreach(j => target(i)(j) = 0))
  //        isPrintable(target)
  //      } else false
  //    } else true
  //  }
}
