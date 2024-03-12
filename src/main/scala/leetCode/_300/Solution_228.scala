package leetCode._300

object Solution_228 {
  def summaryRanges(nums: Array[Int]): List[String] = {
    val seq = nums./:(List[List[Int]]())((l, cur) => {
      if (l.isEmpty) l :+ List(cur)
      else {
        val pre = l.last.last
        if (pre + 1 == cur) l.dropRight(1) :+ (l.last :+ cur)
        else l :+ List(cur)
      }
    })

    seq.map(x => if (x.size > 1) x.head.toString + "->" + x.last else x.head.toString)
  }
}
