package leetCode

object Solution_845 {
  def longestMountain(A: Array[Int]): Int = A.sliding(2)./:(0, 0, false) {
    case ((mx, 0, false), e) if e.head < e.last => (mx, 2, false)
    case ((mx, size, false), e) if e.head < e.last => (mx, size + 1, false)
    case ((mx, _, _), e) if e.head == e.last => (mx, 0, false)
    case ((mx, 0, false), e) if e.head > e.last => (mx, 0, false)
    case ((mx, size, _), e) if e.head > e.last => (mx.max(size + 1), size + 1, true)
    case ((mx, _, true), e) if e.head < e.last => (mx, 2, false)
  }._1
}
