package leetCode

object Solution_1987 {
  def numberOfUniqueGoodSubsequences(binary: String): Int = {
    val M = (1e9 + 7).toLong
    var end0 = 0L
    var end1 = 0L
    var has0 = 0L
    binary.toCharArray.foreach(c => {
      if (c == '1') end1 = (end0 + end1 + 1) % M
      else {
        end0 = (end0 + end1) % M
        has0 = 1
      }
    })
    var res = 0L
    res = (end0 + end1 + has0) % M
    res.toInt
  }
}
