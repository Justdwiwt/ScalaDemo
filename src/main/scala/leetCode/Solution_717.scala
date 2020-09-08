package leetCode

object Solution_717 {
  @scala.annotation.tailrec
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    if (bits.length <= 2) bits(0) == 0 else isOneBitCharacter(bits.slice(bits(0) + 1, bits.length))
  }
}
