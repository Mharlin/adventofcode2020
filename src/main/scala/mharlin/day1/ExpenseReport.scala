package mharlin.day1

object ExpenseReport {
  def generate(expenses: Seq[Int], numberOfValuesToAdd: Int) = {
    expenses
      .combinations(numberOfValuesToAdd)
      .find(_.sum == 2020)
      .map(_.product).getOrElse(0)
  }
}
