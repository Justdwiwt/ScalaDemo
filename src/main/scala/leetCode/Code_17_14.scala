package leetCode

object Code_17_14 {
  def smallestK(arr: Array[Int], k: Int): Array[Int] = {
    if (k > arr.length) return arr
    java.util.Arrays.copyOfRange(arr.sorted, 0, k)
  }
}
