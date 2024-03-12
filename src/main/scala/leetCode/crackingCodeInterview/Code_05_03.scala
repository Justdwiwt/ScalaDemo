package leetCode.crackingCodeInterview

object Code_05_03 {
  def reverseBits(num: Int): Int = {
    val arr = Array.fill(32)(0)
    var idx = 0
    var mx = 0
    var n = num
    while (n != 0) {
      if ((n & 1) == 1) arr(idx) += 1
      else idx += 1
      n >>>= 1
    }
    (0 until arr.length - 1).foreach(i => mx = mx.max(arr(i) + arr(i + 1) + 1))
    mx
  }
}
