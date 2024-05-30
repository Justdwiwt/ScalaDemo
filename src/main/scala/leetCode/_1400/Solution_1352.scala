package leetCode._1400

object Solution_1352 {

  import java.util

  val A: util.ArrayList[Int] = new util.ArrayList[Int]() {
    this.add(1)
  }

  def add(num: Int): Unit = {
    if (num > 0) A.add(A.get(A.size - 1) * num)
    else {
      A.clear()
      A.add(1)
    }
  }

  def getProduct(k: Int): Int = {
    val n = A.size
    if (k < n) A.get(n - 1) / A.get(n - k - 1)
    else 0
  }

}
