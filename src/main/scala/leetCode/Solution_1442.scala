package leetCode

object Solution_1442 {
  def countTriplets(arr: Array[Int]): Int = {
    var res = 0
    arr.indices.dropRight(1).foreach(i => {
      var sum = 0
      (i until arr.length).foreach(j => {
        sum ^= arr(j)
        if (sum == 0 && j > i) res += (j - i)
      })
    })
    res
  }
}
