package leetCode._3100

import scala.collection.mutable

object Solution_3078 {
  def findPattern(board: Array[Array[Int]], pattern: Array[String]): Array[Int] = {
    var res = Array(-1, -1)
    var found = false

    board
      .indices
      .withFilter(!found && _ + pattern.length <= board.length)
      .foreach(i => board(i)
        .indices
        .withFilter(!found && _ + pattern.head.length <= board(i).length)
        .foreach(j => {
          val map = mutable.Map.empty[String, Int]
          val map1 = mutable.Map.empty[Int, String]
          var flag = false

          (i until i + pattern.length)
            .withFilter(_ => !flag)
            .foreach(i1 => (j until j + pattern.head.length)
              .withFilter(_ => !flag)
              .foreach(j1 => {
                val b = board(i1)(j1)
                val p = pattern(i1 - i)(j1 - j).toString

                if (p.forall(_.isDigit)) {
                  val t = p.toInt
                  if (t != b) flag = true
                } else {
                  if (map.contains(p)) if (map(p) != b) flag = true
                  if (map1.contains(b)) if (map1(b) != p) flag = true
                  map(p) = b
                  map1(b) = p
                }

                if (i1 == i + pattern.length - 1 && j1 == j + pattern.head.length - 1 && !flag) {
                  res = Array(i, j)
                  found = true
                }
              }))
        }))

    res
  }
}
