package leetCode

object Solution_969 {
  def pancakeSort(A: Array[Int]): List[Int] = pancake(A.toList, flag = false)

  def pancake(A: List[Int], flag: Boolean = true): List[Int] = {
    if (A.isEmpty) return List[Int]()
    var res = List[Int]()
    val max_idx = A.indexWhere(_ == A.max)
    if (max_idx == 0) {
      res = A.length :: res
      val B = A.reverse
      res = res ::: pancake(B.dropRight(1), flag)
    }
    else {
      val pre = A.slice(0, max_idx + 1).reverse
      val left = A.slice(max_idx + 1, A.length)
      val B = pre ::: left
      res = List(max_idx + 1, B.length) ::: res ::: pancake(B.reverse.dropRight(1), flag)
    }
    res
  }
}
