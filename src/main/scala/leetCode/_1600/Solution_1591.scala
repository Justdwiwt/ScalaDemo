package leetCode._1600

object Solution_1591 {
  //  @scala.annotation.tailrec
  //  def isPrintable(target: Array[Array[Int]]): Boolean = {
  //    val n = target.headOption.map(_.length).getOrElse(0)
  //
  //    val colors = target
  //      .indices
  //      .flatMap(i => (0 until n)
  //        .withFilter(target(i)(_) > 0)
  //        .map(j => target(i)(j) -> ((i, i), (j, j))))
  //      .groupBy(_._1)
  //      .mapValues(_.map(_._2).reduce {
  //        case (((minRow1, maxRow1), (minCol1, maxCol1)), ((minRow2, maxRow2), (minCol2, maxCol2))) =>
  //          ((minRow1.min(minRow2), maxRow1.max(maxRow2)), (minCol1.min(minCol2), maxCol1.max(maxCol2)))
  //      })
  //
  //    if (colors.nonEmpty) {
  //      def isColorPrintable(co: Int): Boolean = colors(co) match {
  //        case ((minRow, maxRow), (minCol, maxCol)) => (minRow to maxRow)
  //          .forall(i => (minCol to maxCol).forall(j => target(i)(j) == 0 || target(i)(j) == co))
  //      }
  //
  //      val printableColors = colors.keySet.filter(isColorPrintable)
  //
  //      if (printableColors.nonEmpty) {
  //        target
  //          .indices
  //          .foreach(i => (0 until n)
  //            .withFilter(j => printableColors.contains(target(i)(j)))
  //            .foreach(target(i)(_) = 0))
  //
  //        isPrintable(target)
  //      } else false
  //
  //    } else true
  //  }
}
