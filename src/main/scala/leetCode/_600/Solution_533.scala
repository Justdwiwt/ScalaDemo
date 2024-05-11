package leetCode._600

object Solution_533 {
  def findBlackPixel(picture: Array[Array[Char]], target: Int): Int = {
    val rowCount = picture.map(_.count(_ == 'B'))
    val colCount = picture.transpose.map(_.count(_ == 'B'))
    val listPair = picture.indices.flatMap(i => picture(i).indices.withFilter(picture(i)(_) == 'B').map((i, _)))
    val hmStr2Cnt = picture.map(_.mkString).groupBy(identity).mapValues(_.length)
    listPair.count { case (i, j) => rowCount(i) == target && colCount(j) == target && hmStr2Cnt.getOrElse(picture(i).mkString, 0) == target }
  }
}
