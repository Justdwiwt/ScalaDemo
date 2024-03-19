package leetCode._2200

object Solution_2151 {
  def maximumGood(statements: Array[Array[Int]]): Int = {
    def statementsHoldForPerson(bitset: Int, i: Int): Boolean = statements
      .indices
      .forall(j => statements(i)(j) == 2 || statements(i)(j) == (bitset >> j & 1))

    def statementsHoldForAll(bitset: Int): Boolean = statements
      .indices
      .filter(i => (bitset >> i & 1) == 1)
      .forall(statementsHoldForPerson(bitset, _))

    @annotation.tailrec
    def countOneBits(bitset: Int, bits: Int): Int =
      if (bitset == 0) bits
      else countOneBits(bitset >> 1, bits + (bitset & 1))

    (0 until 1 << statements.length).collect {
      case bitset if statementsHoldForAll(bitset) => countOneBits(bitset, 0)
    }.max
  }
}
