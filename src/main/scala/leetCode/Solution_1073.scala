package leetCode

object Solution_1073 {
  def addNegabinary(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    var a1 = arr1
    var a2 = arr2
    if (a2.length > a1.length) {
      val t = a1
      a1 = a2
      a2 = t
    }
    val len1 = a1.length
    val len2 = a2.length
    val len3 = len1 + 2
    val res = Array.fill(len3)(0)
    var carry = 0
    (1 to len1).foreach(i => {
      var sum = a1(len1 - i) + carry
      if (i <= len2) sum += a2(len2 - i)
      if (sum >= 0) {
        res(len3 - i) = sum % 2
        carry = -(sum / 2)
      } else {
        res(len3 - i) = 2 + sum
        carry = 1
      }
    })
    if (carry != 0) {
      res(0) = 1
      res(1) = 1
    }
    var idx = 0
    while (idx < len3 - 1 && res(idx) == 0) idx += 1
    java.util.Arrays.copyOfRange(res, idx, len3)
  }
}
