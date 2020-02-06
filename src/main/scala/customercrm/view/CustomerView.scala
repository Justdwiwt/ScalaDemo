package customercrm.view

import customercrm.bean.Customer
import customercrm.service.CustomerService

import scala.io.StdIn
import scala.util.control.Breaks._

class CustomerView {

  var loop = true

  var key = ' '

  var customerService = new CustomerService()

  def mainMenu(): Unit = {
    do {
      println("----------------------")
      println("1.add")
      println("2.modify")
      println("3.del")
      println("4.show")
      println("5.exit")
      println("----------------------")
      println("input 1-5:")
      key = StdIn.readChar()
      key match {
        case '1' => this.add()
        case '2' => println("")
        case '3' => this.del()
        case '4' => this.list()
        case '5' => this.loop = false
      }
    } while (loop)
    println("end")
  }

  def list(): Unit = {
    println()
    println("----------------------")
    println("id\t\tname\t\tgender\t\tage\t\ttel\t\temail")
    val customers = customerService.list()
    customers.foreach(println(_))
    println("----------------------")
  }

  def add(): Unit = {
    println()
    println("----------------------")
    println("name:")
    val name = StdIn.readLine()
    println("gender:")
    val gender = StdIn.readChar()
    println("age:")
    val age = StdIn.readShort()
    println("tel:")
    val tel = StdIn.readLine()
    println("email:")
    val email = StdIn.readLine()
    val customer = new Customer(name, gender, age, tel, email)
    customerService.add(customer)
    println("----------------------")
  }

  def del(): Unit = {
    println()
    println("----------------------")
    println("input id:")
    val id = StdIn.readInt()
    if (id == -1) {
      println("error")
      return
    }
    println("input (Y/N):")
    var choice = ' '
    breakable {
      do {
        choice = StdIn.readChar().toLower
        if (choice == 'y' || choice == 'n') break()
        println("input (Y/N):")
      } while (true)
    }
    if (choice == 'y')
      if (customerService.del(id)) {
        println("success")
        return
      }
    println("error")
  }

}
