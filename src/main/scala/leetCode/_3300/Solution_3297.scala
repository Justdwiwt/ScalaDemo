package leetCode._3300

import scala.collection.mutable

object Solution_3297 {
  def validSubstringCount(word1: String, word2: String): Long = {
    val cntT = word2.groupBy(identity).mapValues(_.length).toMap
    val cntS = mutable.HashMap[Char, Int]()

    var (res, left) = (0L, 0)

    word1.indices.foreach(right => {
      val c = word1(right)
      cntS(c) = cntS.getOrElse(c, 0) + 1

      while (isCovering(cntS.toMap, cntT)) {
        cntS(word1(left)) -= 1
        if (cntS(word1(left)) <= 0) cntS.remove(word1(left))
        left += 1
      }

      res += left
    })

    res
  }

  private def isCovering(cntS: Map[Char, Int], cntT: Map[Char, Int]): Boolean =
    cntT.forall { case (char, count) => cntS.getOrElse(char, 0) >= count }
}
