package leetCode.crackingCodeInterview

object Code_03_01 {

  class TripleInOne(_stackSize: Int) {

    private val st = Array.fill(3 + _stackSize * 3)(0)

    def push(stackNum: Int, value: Int): Unit = {
      if (st(stackNum) == st.length / 3 - 1) return
      st(arrIdx(stackNum, st(stackNum))) = value
      st(stackNum) += 1
    }

    def pop(stackNum: Int): Int = {
      if (isEmpty(stackNum)) return -1
      st(stackNum) -= 1
      st(arrIdx(stackNum, st(stackNum)))
    }

    def peek(stackNum: Int): Int = {
      if (isEmpty(stackNum)) return -1
      st(arrIdx(stackNum, st(stackNum) - 1))
    }

    def isEmpty(stackNum: Int): Boolean = st(stackNum) == 0

    def arrIdx(stackNum: Int, idx: Int): Int = {
      val stSize = st.length / 3 - 1
      3 + stackNum * stSize + idx
    }
  }

}
