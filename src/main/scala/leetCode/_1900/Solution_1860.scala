package leetCode._1900

object Solution_1860 {
  def memLeak(mem1: Int, mem2: Int): Array[Int] = {
    var (m1, m2) = (mem1, mem2)
    if (m1 == 0 && m2 == 0) return Array(1, 0, 0)
    var cnt = 1
    while (m1 >= cnt || m2 >= cnt) {
      if (m1 < m2) m2 -= cnt
      else m1 -= cnt
      cnt += 1
    }
    Array(cnt, m1, m2)
  }
}
