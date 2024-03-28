package leetCode._1300

object Solution_1239 {
  def maxLength(arr: List[String]): Int = {
    def lengthTail(rest: List[String], acc: String): List[String] = rest.headOption match {
      case None => List(acc)
      case Some(head) => lengthTail(rest.tail, acc) ++ {
        if ((head.length == head.toSet.size) && acc.intersect(head).isEmpty) lengthTail(rest.tail, acc + head)
        else Nil
      }
    }

    lengthTail(arr, "").map(_.length).max
  }
}
