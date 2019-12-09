package leetCode

object Solution_1238 {

  def circularPermutation(n: Int, start: Int): List[Int] = {
    var res = List.empty[Int]
    (0 until (1 << n)).foreach(i => res :+= (start ^ i ^ (i >> 1)))
    res
  }

  def grayCode(n: Int): List[Int] = n match {
    case 1 => List(0, 1)
    case x if x <= 0 => List.empty
    case _ =>
      val pre = grayCode(n - 1)
      var res = List.empty[Int]
      res = pre
      (pre.length - 1 to 0 by -1).foreach(i => res :+= (pre(i) + (1 << n - 1)))
      res
  }

  def grayCodeCircle(n: Int): List[Int] = n match {
    case 1 => List(0, 1)
    case x if x <= 0 => List.empty
    case _ =>
      var res = List.empty[Int]
      res :+= 0
      res :+= 1
      (2 to n).foreach(i => (res.length - 1 to 0 by -1).foreach(j => res :+= (res(j) + (1 << (i - 1)))))
      res
  }

}
