package leetCode

object Code_05_07 {
  def exchangeBits(num: Int): Int = ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1)
}
