package leetCode._1700

object Solution_1678 {
  def interpret(command: String): String = {
    command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al")
  }
}
