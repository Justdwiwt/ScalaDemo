package leetCode

object Code_10_03 {
  def search(arr: Array[Int], target: Int): Int = {
    arr.indices.foreach(i => if (arr(i) == target) return i)
    -1
  }
}
