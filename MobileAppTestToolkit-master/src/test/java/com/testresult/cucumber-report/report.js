$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TC_1.feature");
formatter.feature({
  "id": "odoo-pos",
  "description": "",
  "name": "odoo POS",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 59931125000,
  "status": "passed"
});
formatter.scenario({
  "id": "odoo-pos;navigate-to-pos",
  "tags": [
    {
      "name": "@iOS",
      "line": 3
    }
  ],
  "description": "",
  "name": "Navigate to POS",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "Open app",
  "keyword": "Given ",
  "line": 6
});
formatter.match({
  "location": "SuiteSteps.Open_app()"
});
formatter.embedding("image/png", "embedded0.png");
formatter.embedding("image/png", "embedded1.png");
formatter.embedding("image/png", "embedded2.png");
formatter.result({
  "duration": 12299245000,
  "status": "passed"
});
formatter.after({
  "duration": 6031614000,
  "status": "passed"
});
});