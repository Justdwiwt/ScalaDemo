package leetCode

object Solution_1385 {
  def findTheDistanceValue(arr1: Array[Int], arr2: Array[Int], d: Int): Int = {
    arr1.count(x => arr2.forall(y => (x - y).abs > d))
  }
}
