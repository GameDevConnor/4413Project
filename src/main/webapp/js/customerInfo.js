function goBack() {
    // Go back in the browser's history
    window.history.back();
}

function validate() {
 
	console.log("called customerInfo.js");

    if (document.forms["signUpForm"]["password"].value == "") {
        alert("Password should be filled out");
        document.forms["signUpForm"]["password"].focus();
        return false;
    } // check if the Password field is missing

    if (document.forms["signUpForm"]["firstname"].value == "") {
      alert("First name should be filled out");
      document.forms["signUpForm"]["firstname"].focus();
      return false;
    } // check if the First Name data is missing

    if (document.forms["signUpForm"]["lastname"].value == "") {
        alert("Last name should be filled out");
        document.forms["signUpForm"]["lastname"].focus();
        return false;
    } // check if the Last Name data is missing
    
    if (document.forms["signUpForm"]["street"].value == "") {
        alert("Street should be filled out");
        document.forms["signUpForm"]["street"].focus();
        return false;
    } // check if the street field is missing

    if (document.forms["signUpForm"]["province"].value == "") {
      alert("Province should be filled out");
      document.forms["signUpForm"]["province"].focus();
      return false;
    } // check if the province data is missing

    if (document.forms["signUpForm"]["country"].value == "") {
        alert("Country should be filled out");
        document.forms["signUpForm"]["country"].focus();
        return false;
    } // check if the country data is missing
    
    if (document.forms["signUpForm"]["zip"].value == "") {
      alert("Zip should be filled out");
      document.forms["signUpForm"]["zip"].focus();
      return false;
    } // check if the province data is missing

    if (document.forms["signUpForm"]["phone"].value == "") {
        alert("Phone should be filled out");
        document.forms["signUpForm"]["phone"].focus();
        return false;
    } // check if the country data is missing

	// direct to CustomerControllerForAdmin to insert new user to DB
    document.forms["signUpForm"].action="customers";
    document.forms["signUpForm"].method="get";
    
    console.log("Query String: "+ window.location.search);
  }  // validate various form components
  
