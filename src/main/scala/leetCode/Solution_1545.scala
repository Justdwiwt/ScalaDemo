package leetCode

object Solution_1545 {
  def findKthBit(n: Int, k: Int): Char = {
    if (n == 1 || k == 1) return '0'
    if (k == math.pow(2, n - 1)) return '1'
    if (k < math.pow(2, n - 1)) findKthBit(n - 1, k)
    else if (findKthBit(n, math.pow(2, n).toInt - k) == '1') '0'
    else '1'
  }
}
