package leetCode

object Solution_1200 {
  def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
    val sorted = arr.sorted
    val res = sorted.zip(sorted.slice(1, sorted.length))
    val mn = res.map({ case (a, b) => b - a }).min
    res.filter({ case (a, b) => (b - a) == mn }).map(t => List(t._1, t._2)).toList
  }
}
