package customercrm.service

import customercrm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

class CustomerService {

  var customerNum = 1

  private val customers = ArrayBuffer(new Customer(1, "tom", '1', 10, "110", "exp@exp.com"))

  def list(): ArrayBuffer[Customer] = this.customers

  def add(customer: Customer): Boolean = {
    customerNum += 1
    customer.id = customerNum
    customers.append(customer)
    true
  }

  def del(id: Int): Boolean = {
    val idx = findById(id)
    if (idx != -1) {
      customers.remove(idx)
      true
    } else false
  }

  def findById(id: Int): Int = {
    var idx = -1
    breakable {
      customers.indices.foreach(i => {
        if (customers(i).id == id) {
          idx = i
          break()
        }
      })
    }
    idx
  }

}
