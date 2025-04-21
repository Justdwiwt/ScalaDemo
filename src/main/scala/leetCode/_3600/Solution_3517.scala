package leetCode._3600

object Solution_3517 {
  def smallestPalindrome(s: String): String = {
    val list = s.toCharArray.groupBy(identity).toList.sortBy(_._1).map(_._2)
    val value = list.foldLeft("")((acc, array) => acc + array.take(array.length / 2).mkString)
    list.find(_.length % 2 == 1) match {
      case None => value + value.reverse
      case Some(array) => value + array.head + value.reverse
    }
  }
}
