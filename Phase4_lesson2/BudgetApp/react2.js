let expense_input = document.getElementById("expense-input");
let budget_input = document.getElementById("budget-input");
let budget_label = document.getElementById("budget-label");
let btn_expense = document.getElementById("expense-btn");
let btn_budget = document.getElementById("budget-btn");
let expense_form = document.getElementById("expense-form");
let budget_form = document.getElementById("budget-form");
let budget_btn = document.getElementById("budget-btn");
let expense_btn = document.getElementById("expense-form");

let expense;
let budget;
let balance;

let formData = new FormData(budget_form);

budget_form.addEventListener('submit', (event) => {
    // handle the form data
    expense = formData.get('budget-input');
    console.log(this.expense);
});