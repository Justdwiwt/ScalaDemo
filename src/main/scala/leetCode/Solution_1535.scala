package leetCode

object Solution_1535 {
  def getWinner(arr: Array[Int], k: Int): Int = {
    var res = arr.head
    var cnt = 0
    arr.indices.drop(1).withFilter(_ => cnt < k).foreach(i => {
      if (arr(i) < res) cnt += 1
      else {
        res = arr(i)
        cnt = 1
      }
    })
    res
  }
}
