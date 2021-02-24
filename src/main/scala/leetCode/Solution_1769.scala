package leetCode

object Solution_1769 {
  def minOperations(boxes: String): Array[Int] = {
    val right = 0
    val (left, cnt, _) = boxes.:\((0, 0, 1))((c, acc) => {
      c match {
        case '1' => (acc._1 + 1, acc._2 + acc._3, acc._3 + 1)
        case '0' => (acc._1, acc._2, acc._3 + 1)
      }
    })
    val (r, _, _, _) = boxes.:\((Array.emptyIntArray, right, left, cnt))((c, acc) => {
      val t = acc._4 - acc._3 + acc._2
      c match {
        case '1' => (t +: acc._1, acc._2 + 1, acc._3 - 1, t)
        case '0' => (t +: acc._1, acc._2, acc._3, t)
      }
    })
    r
  }
}
