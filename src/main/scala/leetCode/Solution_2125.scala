package leetCode

object Solution_2125 {
  def numberOfBeams(bank: Array[String]): Int = {
    var res = 0
    var last = 0
    bank.indices.foreach(i => {
      var cnt = 0
      bank(i).indices.foreach(j => cnt += (if (bank(i)(j) == '1') 1 else 0))
      res += cnt * last
      last = if (cnt != 0) cnt else last
    })
    res
  }
}
