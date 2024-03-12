package leetCode._1100

object Solution_1095 {

  class MountainArray {
    def get(index: Int): Int = ???

    def length(): Int = ???
  }

  def findInMountainArray(value: Int, mountainArr: MountainArray): Int = {
    val peak = findPeak(0, mountainArr.length() - 1, mountainArr)
    val l = binarySearchLeft(value, 0, peak, mountainArr)
    if (l != -1) return l
    val r = binarySearchRight(value, peak + 1, mountainArr.length() - 1, mountainArr)
    r
  }

  def findPeak(left: Int, right: Int, mountainArr: MountainArray): Int = {
    var l = left
    var r = right
    while (l < r) {
      val m = l + (r - l) / 2
      if (mountainArr.get(m) < mountainArr.get(m + 1)) l = m + 1
      else r = m
    }
    l
  }

  def binarySearchLeft(target: Int, left: Int, right: Int, mountainArr: MountainArray): Int = {
    var l = left
    var r = right
    while (l <= r) {
      val m = l + (r - l) / 2
      if (target == mountainArr.get(m)) return m
      else if (target < mountainArr.get(m)) r = m - 1
      else l = m + 1
    }
    -1
  }

  def binarySearchRight(target: Int, left: Int, right: Int, mountainArr: MountainArray): Int = {
    var l = left
    var r = right
    while (l <= r) {
      val m = l + (r - l) / 2
      if (target == mountainArr.get(m)) return m
      else if (target < mountainArr.get(m)) l = m + 1
      else r = m - 1
    }
    -1
  }

}
