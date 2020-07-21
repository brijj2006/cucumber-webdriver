$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/google_search.feature");
formatter.feature({
  "line": 1,
  "name": "google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6947644544,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "test google search",
  "description": "",
  "id": "google-search;test-google-search",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@page_setup"
    },
    {
      "line": 3,
      "name": "@smoke_test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "open application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "search for item \"hello world\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "verify element \"All\" is present on the page",
  "keyword": "Then "
});
formatter.match({
  "location": "UIGlue.openApplication()"
});
formatter.result({
  "duration": 3068826970,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hello world",
      "offset": 17
    }
  ],
  "location": "UIGlue.searchForItem(String)"
});
formatter.result({
  "duration": 3218493843,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "All",
      "offset": 16
    }
  ],
  "location": "UIGlue.verifyElementIsPresentOnThePage(String)"
});
formatter.result({
  "duration": 73153839,
  "status": "passed"
});
formatter.after({
  "duration": 167138666,
  "status": "passed"
});
});