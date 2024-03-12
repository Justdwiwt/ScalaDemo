package leetCode._2700

object Solution_2657 {
  def findThePrefixCommonArray(A: Array[Int], B: Array[Int]): Array[Int] = {
    val idx = A.map(B.indexOf(_))

    def count(i: Int): Int =
      idx.take(i + 1).count(_ <= i)

    A.indices.map(count).toArray
  }
}
