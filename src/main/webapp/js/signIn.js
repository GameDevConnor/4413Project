function validate() {
    if (document.forms["signinForm"]["username"].value == "") {
      alert("Username should be filled out");
      document.forms["myForm"]["username"].focus();
      return false;
    } // check if the User Name data is missing

    if (document.forms["signinForm"]["password"].value == "") {
        alert("Password should be filled out");
        document.forms["signinForm"]["password"].focus();
        return false;
    } // check if the Password field is missing
	//alert("User Controller for Signin");
	// Servlet: check credentials in DB and update the action
    //document.forms["signinForm"].action="signUp.html";
    document.forms["signinForm"].action="SignIn";
    document.forms["signinForm"].method="get";
    

  }  // validate various form components