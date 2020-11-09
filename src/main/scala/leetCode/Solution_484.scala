package leetCode

object Solution_484 {
  def findPermutation(s: String): Array[Int] = {
    val t = s + 'I'
    val res = Array.fill(t.length)(0)
    var cur = 1
    var last = 0
    t.indices.foreach(i => if (t(i) == 'I') {
      (i to last by -1).foreach(j => {
        res(j) = cur
        cur += 1
      })
      last = i + 1
    })
    res
  }
}
