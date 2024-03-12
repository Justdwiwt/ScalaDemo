package leetCode._2000

import java.lang.Math.negateExact

object Solution_1943 {
  case class ColorDiff(coord: Int, colorDiff: Long)

  def extract(list: List[ColorDiff]): (Long, Int, List[ColorDiff]) = list match {
    case Nil => ???
    case h :: tail =>
      val same = tail.takeWhile(_.coord == h.coord)
      val rem = tail.drop(same.length)
      ((h :: same).map(_.colorDiff).sum, h.coord, rem)
  }

  @scala.annotation.tailrec
  def f(preColor: Long, preCoord: Int, rem: List[ColorDiff], res: List[List[Long]]): List[List[Long]] = {
    val (nColor, nCoord, nRem) = extract(rem)
    val nRes = if (preColor == 0) res else List(preCoord, nCoord, preColor) :: res
    if (nRem.isEmpty) nRes.reverse
    else f(nColor + preColor, nCoord, nRem, nRes)
  }

  def g(segments: Array[Array[Int]]): List[ColorDiff] = segments
    .toList
    .flatMap(arr => List(ColorDiff(arr(0), arr(2)), ColorDiff(arr(1), negateExact(arr(2)))))
    .sortBy(_.coord)

  def splitPainting(segments: Array[Array[Int]]): List[List[Long]] =
    f(extract(g(segments))._1, extract(g(segments))._2, extract(g(segments))._3, List.empty)
}
