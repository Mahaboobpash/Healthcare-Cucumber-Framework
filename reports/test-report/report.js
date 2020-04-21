$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/LoginFunctionality.feature");
formatter.feature({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "user searches for the product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Shopping_page-datatable"
    }
  ]
});
formatter.step({
  "name": "user is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefnitions.Steps.user_is_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search for product",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepDefnitions.Steps.user_search_for_product(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefnitions.Steps.product_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
});