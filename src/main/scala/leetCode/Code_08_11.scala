package leetCode

object Code_08_11 {
  def waysToChange(n: Int): Int = {
    val M = 1000000007
    val diff = Array(25, 10, 5, 1)
    val res = Array.fill(n + 1)(0)
    res(0) = 1
    diff.foreach(v => (v to n).foreach(i => res(i) = (res(i) + res(i - v)) % M))
    res(n)
  }
}
