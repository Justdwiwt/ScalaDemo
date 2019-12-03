package leetCode

object Solution_1200 {
  def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
    val t = arr.sorted
    var res = List[List[Int]]()
    var diff = t(t.length - 1) - t(0)
    (1 until t.length).foreach(i => diff = diff.min(t(i) - t(i - 1)))
    (1 until t.length).foreach(i => {
      var tmp = List[Int]()
      if (diff == t(i) - t(i - 1)) {
        tmp :+= t(i - 1)
        tmp :+= t(i)
        res :+= tmp
      }
    })
    res
  }
}
