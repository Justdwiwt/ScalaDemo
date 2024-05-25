package leetCode._2900

object Solution_2802 {
  def kthLuckyNumber(k: Int): String = {
    var srt = 1
    var sm = 2
    var p = 4

    while (k > sm) {
      sm += p
      srt += 1
      p *= 2
    }

    Integer
      .parseInt((k - 1 - sm + p / 2).toBinaryString, 2)
      .toBinaryString
      .reverse
      .padTo(srt, '0')
      .reverse
      .replace('0', '4')
      .replace('1', '7')

  }
}
