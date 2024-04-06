package leetCode._400

object Solution_379 {

  class PhoneDirectory(_maxNumbers: Int) {

    private val phone = Array.fill(_maxNumbers)(true)
    private val size = _maxNumbers

    def get(): Int = {
      val index = (0 until size).find(phone(_))
      index.foreach(phone(_) = false)
      index.getOrElse(-1)
    }

    def check(number: Int): Boolean =
      phone(number)

    def release(number: Int): Unit =
      phone(number) = true
  }

}
