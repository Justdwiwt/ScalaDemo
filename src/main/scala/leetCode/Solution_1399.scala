package leetCode

object Solution_1399 {
  def countLargestGroup(n: Int): Int = {
    var res = 0
    var mx = 1
    val cnt = Array.fill(n + 1)(0)
    val sum = Array.fill(n + 1)(0)
    (1 to n).foreach(i => {
      sum(i) = sum(i / 10) + i % 10
      cnt(sum(i)) += 1
      if (cnt(sum(i)) > mx) mx = cnt(sum(i))
    })
    cnt.foreach(i => res += (if (i == mx) 1 else 0))
    res
  }
}
