package leetCode

object Solution_433 {
  def minMutation(start: String, end: String, bank: Array[String]): Int = {
    val res = backTrack(start, end, bank, new Array[Boolean](bank.length))
    if (res > bank.length) return -1
    res
  }

  def backTrack(current: String, end: String, bank: Array[String], used: Array[Boolean]): Int = {
    if (current.equals(end)) return 0
    var res = bank.length + 1
    bank.indices.foreach(i => {
      if (!used(i) && func(current, bank(i))) {
        used(i) = true
        res = math.min(1 + backTrack(bank(i), end, bank, used), res)
        used(i) = false
      }
    })
    res
  }

  def func(a: String, b: String): Boolean = {
    var cnt = 0
    (0 until 8).foreach(i => {
      if (a(i) != b(i)) cnt += 1
      if (cnt > 1) return false
    })
    cnt == 1
  }

}
