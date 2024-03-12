package leetCode._2900

object Solution_2899 {
  def lastVisitedIntegers(words: List[String]): List[Int] = {
    var res = List.empty[Int]
    var a = List.empty[Int]
    var k = 0
    words.foreach(s => if (s.charAt(0) != 'p') {
      a = a :+ s.toInt
      k = 0
    } else {
      k += 1
      res = res :+ (if (k > a.size) -1 else a(a.size - k))
    })
    res
  }
}
