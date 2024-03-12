package leetCode._300

import scala.collection.mutable

object Solution_241 {
  def diffWaysToCompute(input: String): List[Int] = {
    val (operands, operations) = parse(input)
    if (operands.length <= 1) operands
    else diffWays(0, operands.length - 1, operands, operations, mutable.Map.empty[(Int, Int), List[Int]])
  }

  def diffWays(start: Int, end: Int, operands: List[Int], operations: List[Char], m: mutable.Map[(Int, Int), List[Int]]): List[Int] =
    if (operands.isEmpty) Nil
    else if (operands.length == 1) operands
    else {
      var res = List.empty[Int]
      operands.indices.drop(1).foreach(i => {
        val lefts = diffWays(start, start + i, operands.take(i), operations, m)
        val rights = diffWays(start + i + 1, end, operands.drop(i), operations.drop(i), m)
        res = res ++ lefts.flatMap(l => rights.map(r => compute(l, r, operations(i - 1))))
      })
      m((start, end)) = res
      res
    }

  def parse(input: String): (List[Int], List[Char]) = {
    val operands = input.split(Array('+', '-', '*')).map(Integer.parseInt).toList
    var operations = List.empty[Char]
    input.indices.reverse.foreach(i => if (!input(i).isDigit) operations = input(i) :: operations)
    (operands, operations)
  }

  def compute(left: Int, right: Int, operation: Char): Int = operation match {
    case '+' => left + right
    case '-' => left - right
    case '*' => left * right
  }
}
