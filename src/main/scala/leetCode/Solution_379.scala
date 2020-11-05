package leetCode

object Solution_379 {

  class PhoneDirectory(_maxNumbers: Int) {

    private val phone = Array.fill(_maxNumbers)(true)
    private val size = _maxNumbers

    def get(): Int = {
      (0 until size).foreach(i => if (phone(i)) {
        phone(i) = false
        return i
      })
      -1
    }

    def check(number: Int): Boolean = phone(number)

    def release(number: Int) {
      phone(number) = true
    }

  }

}
