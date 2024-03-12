package leetCode._2500

object Solution_2429 {
  def minimizeXor(num1: Int, num2: Int): Int =
    remove(num2.toBinaryString.count(_ == '1'), 0, num1, 1 << 30)

  @scala.annotation.tailrec
  def remove(cnt: Int, res: Int, num: Int, mask: Int): Int =
    if (cnt <= 0) res
    else if (num == 0) add(cnt, res, 1)
    else if ((num & mask) > 0) remove(cnt - 1, res | mask, num ^ mask, mask >> 1)
    else remove(cnt, res, num, mask >> 1)

  @scala.annotation.tailrec
  def add(cnt: Int, res: Int, mask: Int): Int =
    if (cnt <= 0) res
    else if ((res & mask) > 0) add(cnt, res, mask << 1)
    else add(cnt - 1, res ^ mask, mask << 1)
}
