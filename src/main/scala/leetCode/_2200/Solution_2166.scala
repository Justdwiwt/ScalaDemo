package leetCode._2200

object Solution_2166 {
  class Bitset(_size: Int) {

    private var tar = Array.fill(_size)('0')
    private var rev = Array.fill(_size)('1')
    private var cnt = 0

    def fix(idx: Int) {
      if (tar(idx) == '0') {
        tar(idx) = '1'
        cnt += 1
      }
      rev(idx) = '0'
    }

    def unfix(idx: Int) {
      if (tar(idx) == '1') {
        tar(idx) = '0'
        cnt -= 1
      }
      rev(idx) = '1'
    }

    def flip() {
      val t = rev
      rev = tar
      tar = t
      cnt = tar.length - cnt
    }

    def all(): Boolean = {
      cnt == tar.length
    }

    def one(): Boolean = {
      cnt > 0
    }

    def count(): Int = {
      cnt
    }

    override def toString: String = {
      tar.mkString
    }

  }
}
