package leetCode._1300

object Solution_1296 {
  def isPossibleDivide(nums: Array[Int], k: Int): Boolean = {
    @scala.annotation.tailrec
    def f(map: Map[Int, Int]): Boolean = {
      if (map.isEmpty) true
      else {
        val minCard = map.minBy(_._1)._1
        val newGroup = minCard until minCard + k
        if (newGroup.forall(map.contains)) {
          val newMap = newGroup.foldLeft(map)((cur, i) => cur.get(i) match {
            case Some(count) if count > 1 => cur.updated(i, count - 1)
            case Some(_) => cur - i
            case None => cur
          })
          f(newMap)
        } else false
      }
    }

    val m = nums.groupBy(identity).mapValues(_.length)

    f(m)
  }
}
