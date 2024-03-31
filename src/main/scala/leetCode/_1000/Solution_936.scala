package leetCode._1000

object Solution_936 {
  def movesToStamp(stamp: String, target: String): Array[Int] = {
    def canRemoveStamp(target: Map[Int, Char], start: Int): Boolean =
      stamp.indices.foldLeft(false)((hasMatchingLetter, i) => {
        if (target(start + i) == '?') hasMatchingLetter
        else if (target(start + i) == stamp(i)) true
        else return false
      })

    @scala.annotation.tailrec
    def movesToStamp(target: Map[Int, Char], stampings: List[Int]): List[Int] = {
      val (newTarget, removedStamp, newStampings) = (0 to target.size - stamp.length)
        .foldLeft(target, false, stampings) { case ((target, removedStamp, stampings), start) =>
          if (!canRemoveStamp(target, start)) (target, removedStamp, stampings)
          else (target ++ (start until start + stamp.length).map(_ -> '?'), true, start +: stampings)
        }
      if (removedStamp) movesToStamp(newTarget, newStampings)
      else if (newTarget.values.forall(_ == '?')) newStampings
      else List.empty
    }

    movesToStamp(target.indices.zip(target).toMap, stampings = List.empty).toArray
  }
}
