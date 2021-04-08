enum class BankLocation{
    CHENNAI,
    KOCHI,
    PUNE
}

abstract class BankTransactions {
    protected abstract fun addTransaction(message: String)
}

interface SavingsAccount{

    fun deposit(n: Int)
    fun withdraw(n: Int)

}

class Customer: BankTransactions, SavingsAccount {

    val homeBranch: BankLocation = BankLocation.CHENNAI
    var balance: Int = 0
    val transactions = ArrayList<String>(5)

    constructor(_username: String, _password: String, _name: String, _address: String, _phone: String, _balance: Int) {

        val username = _username
        val password = _password
        val name = _name
        val address = _address
        val phone = _phone
        balance = _balance

        addTransaction("Intial deposit - " + balance)

    }

    override protected fun addTransaction(message: String){
        transactions.add(0, message);

        if(transactions.size > 5)
            transactions.removeAt(5)

    }


    override fun deposit(amount: Int) {
        balance += amount;
        addTransaction("$amount credited to your account. Balance - $balance")
    }

    override fun withdraw(amount: Int){
        if(amount > (balance - 200)) {
            println("Insufficent balance.")
        }
        balance -= amount
        addTransaction("$amount debited from your account. Balance -  $balance")
    }

    fun showTranscations() {
        for(transaction in transactions)
            println(transaction)
    }

}

fun main(){

    var customerMap = mutableMapOf<String, Customer>()

    var customer = Customer("snb", "1302", "soorya", "kochi", "13",  500)
    customerMap.put("snb", customer)
    customer.deposit(500)
    customer.withdraw(200)
    customer.showTranscations()

}