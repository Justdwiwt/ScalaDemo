package leetCode

object Solution_922 {
  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    val res = Array.fill(A.length)(0)
    var t = 0
    A.foreach(i => if (i % 2 == 0) {
      res(t) = i
      t += 2
    })
    t = 1
    A.foreach(i => if (i % 2 == 1) {
      res(t) = i
      t += 2
    })
    res
  }
}
